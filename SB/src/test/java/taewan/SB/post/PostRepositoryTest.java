package taewan.SB.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import taewan.SB.dto.post.PostSaveDto;
import taewan.SB.entity.Post;
import taewan.SB.repository.PostRepository;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static taewan.SB.post.PostTestFixture.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PostRepositoryTest {
    @Autowired private PostRepository repository;

    @Test
    void 게시물_저장() {
        //given
        Post post = createPost(1L);

        //when
        Post saved = repository.save(post);
        
        //then
        assertThat(saved.toString()).isEqualTo(post.toString());
        assertThat(repository.count()).isEqualTo(1L);
    }

    @Test
    void 게시물_삭제() {
        //given
        Post post = createPost(1L);

        //when
        Post saved = repository.save(post);
        repository.deleteById(saved.getPostId());

        //then
        assertThat(repository.count()).isEqualTo(0L);
    }

    @Test
    void 게시물_단일조회() {
        //given
        Post post = createPost(1L);

        //when
        Post saved = repository.save(post);

        //then
        repository.findById(saved.getPostId())
                .ifPresent(p -> assertThat(p.toString()).isEqualTo(post.toString()));
    }

    @Test
    void 공개게시물_단일조회() {
        //given
        PostSaveDto nonActive = createDto(1L);
        PostSaveDto active = createDto(2L);
        active.setActivity(true);

        //when
        Post saved1 = repository.save(new Post(nonActive));
        Post saved2 = repository.save(new Post(active));

        //then
        assertThat(repository.findActiveOne(saved1.getPostId())).isEmpty();
        repository.findActiveOne(saved2.getPostId())
                .ifPresent(o1 -> assertThat(o1.toString()).isEqualTo(saved2.toString()));
    }

    @Test
    void 없는_게시물_단일조회() {
        //given

        //when //then
        assertThat(repository.findById(1L).isEmpty()).isTrue();
    }

    @Test
    void 게시물_공개여부변경() {
        //given
        Post post = createPost(1L);

        //when
        Long id = repository.save(post).getPostId();

        //then
        repository.findById(id)
                .ifPresent(p -> assertThat(p.getActivity()).isFalse());
        repository.modifyActivityById(id);
        repository.findById(id)
                .ifPresent(p -> assertThat(p.getActivity()).isTrue());
        repository.modifyActivityById(id);
        repository.findById(id)
                .ifPresent(p -> assertThat(p.getActivity()).isFalse());
    }

    @Test
    void 게시물_전체조회() {
        //given
        int index = 5;
        int mid = index / 2;
        List<Post> posts = new ArrayList<>(index);

        for (int i = 1; i <= index; i++) {
            PostSaveDto dto = createDto(i);

            if (i <= mid) dto.setActivity(true);
            posts.add(new Post(dto));
        }

        //when
        repository.saveAll(posts);
        Collections.sort(posts, (o1, o2) -> {
            if (o1.getPostId() < o2.getPostId())
                return 1;
            return -1;
        });
        List<Post> found = repository.findAll(Sort.by(Sort.Direction.DESC, "postId"));

        //then
        for (int i = 0; i < index; i++)
            assertThat(found.get(i).toString()).isEqualTo(posts.get(i).toString());
        assertThat(found.size()).isEqualTo(index);
    }

    @Test
    void 공개게시물_전체조회() {
        //given
        int index = 5;
        int mid = index / 2;
        List<Post> posts = new ArrayList<>(index);

        for (int i = 1; i <= index; i++) {
            PostSaveDto dto = createDto(i);

            if (i <= mid) dto.setActivity(true);
            posts.add(new Post(dto));
        }

        //when
        List<Post> saved = repository.saveAll(posts);

        //then //find limit 10
        assertThat(repository.findActiveAll(0, 0L).size()).isEqualTo(mid);
    }

    @Test
    void 공개게시물_조회with태그() {
        //given
        int index = 15;
        int div = 3;
        int add = 10;
        List<Post> posts = new ArrayList<>(index);

        for (int i = 1; i <= index + add; i++) {
            PostSaveDto dto = createDto(i, (long)Math.pow(2, i % div));

            if (i <= 15)
                dto.setActivity(true);
            posts.add(new Post(dto));
        }

        //when
        List<Post> saved = repository.saveAll(posts);

        //then //find limit 10
        assertThat(repository.findActiveAll(0, 0L).size()).isEqualTo(add);
        assertThat(repository.findActiveAll(0, 1L).size()).isEqualTo(5);
        assertThat(repository.findActiveAll(0, 2L).size()).isEqualTo(5);
    }

    @Test
    void 게시물_없는_경우_전체조회() {
        //given

        //when //then
        assertThat(repository.findAll(Sort.by(Sort.Direction.DESC, "postId")))
                .isEmpty();
    }
}