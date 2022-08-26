package taewan.SBadmin.post;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Slice;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dto.PostSaveDto;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostDaoTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostDao postDao;

    @Test
    public void 게시물저장테스트() {
        //given
        List<Post> posts = createPost(5);
        List<Post> savedPosts = new LinkedList<>();

        //when
        for (Post post : posts)
            savedPosts.add(postDao.save(post));

        //then
        assertThat(savedPosts.size()).isEqualTo(5);
        for (int i = 0; i < 5; i++) {
            Post post = posts.get(i);
            Post save = savedPosts.get(i);
            assertThat(post.toString()).isEqualTo(save.toString());
        }
    }

    @Test
    public void 게시물조회테스트bySlice() {
        //given
        List<Post> posts = createPost(18);

        for (Post post : posts)
            postDao.save(post);

        //when
        Slice<Post> sliced1 = postDao.findAll(0);
        Slice<Post> sliced2 = postDao.findAll(1);

        //then
        assertThat(sliced1.getNumberOfElements()).isEqualTo(10);
        assertThat(sliced2.getNumberOfElements()).isEqualTo(8);
    }

    @Test
    public void 게시물삭제테스트() {
        //given
        List<Post> posts = createPost(1);
        Post save = postDao.save(posts.get(0));

        //when
        postDao.delete(save.getPostId());

        //then
        assertThat(postRepository.countAllBy()).isEqualTo(0);
    }

    private List<Post> createPost(int num) {
        List<Post> posts = new ArrayList<>(num);

        while (num-- > 0) {
            PostSaveDto postSaveDto = PostSaveDto.builder()
                    .title("test post title" + num)
                    .content("1. test\n2. test\n3. test")
                    .imgPath("test img path")
                    .expirationDate(LocalDateTime.now().plusDays(3L))
                    .needConditions(Long.parseLong("00111111111111111101111111111111111111111", 2))
                    .needDocuments(Long.parseLong("00111111111111111101111111111111111111111", 2))
                    .procedure("test procedure")
                    .build();
            posts.add(postSaveDto.convert());
        }
        return posts;
    }
}
