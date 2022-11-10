package taewan.SBadmin.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.entity.Post;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Autowired PostRepository repository;

    private Post createPost(int index) {
        return new Post(PostSaveDto.builder()
                .title("test title" + index)
                .content("test content" + index)
                .imgPath("http://test.com/img/" + index)
                .url("http://test.com/" + index)
                .expirationDate(LocalDateTime.now().plusDays(10))
                .tags(1L)
                .activity(false)
                .build());
    }

    @Transactional
    @Test
    void 게시물저장() {
        //given
        Post post = createPost(0);

        //when
        Post save = repository.save(post);

        //then
        assertThat(save.toString()).isEqualTo(post.toString());
    }

    @Transactional
    @Test
    void 게시물삭제() {
        //given
        Post post = createPost(0);

        //when
        Post save = repository.save(post);
        repository.deleteById(save.getPostId());

        //then
        assertThat(repository.count()).isEqualTo(0);
    }

    @Transactional
    @Test
    void 게시물공개여부변경() {
        //given
        Post post = createPost(0);

        //when
        Long id = repository.save(post).getPostId();

        //then
        repository.modifyPostActivityByPostId(id);
        repository.findById(id).ifPresent(
                p -> assertThat(p.getActivity()).isTrue());
        repository.modifyPostActivityByPostId(id);
        repository.findById(id).ifPresent(
                p -> assertThat(p.getActivity()).isFalse());
    }

    @Transactional
    @Test
    void 게시물전체조회() {
        //given
        List<Post> posts = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            posts.add(createPost(i));

        //when
        List<Post> saved = repository.saveAll(posts);

        //then
        for (int i = 0; i < posts.size(); i++)
            assertThat(saved.get(i).toString()).isEqualTo(posts.get(i).toString());
    }

    @Transactional
    @Test
    void 공개게시물전체조회() {
        //given
        List<Post> posts = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            posts.add(createPost(i));

        //when
        List<Post> saved = repository.saveAll(posts);

        for (int i = 0; i < 5; i++)
            if (i % 2 == 1)
                repository.modifyPostActivityByPostId(saved.get(i).getPostId());

        //then //find limit 10
        assertThat(repository.findActivePostsAll(0).size()).isEqualTo(2);
    }

    @Transactional
    @Test
    void 공개게시물조회with태그() {
        //given
        List<Post> posts = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            posts.add(createPost(i));

        //when
        List<Post> saved = repository.saveAll(posts);

        for (int i = 0; i < 5; i++) {
            repository.modifyPostActivityByPostId(saved.get(i).getPostId());
            if (i % 2 == 1)
                repository.findById(saved.get(i).getPostId()).ifPresent(
                        p -> p.setTags(2L));
        }

        //then //find limit 10
        assertThat(repository.findActivePostsAll(0, 1L).size()).isEqualTo(3);
        assertThat(repository.findActivePostsAll(0, 2L).size()).isEqualTo(2);
    }
}