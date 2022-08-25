package taewan.SBadmin.post;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taewan.SBadmin.dao.PostDao;
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
        Post post = createPost(1).get(0);

        //when
        Post save = postDao.save(post);

        //then
        assertThat(save.toString()).isEqualTo(post.toString());
    }

    @Test
    public void 게시물전체조회() {
        //given
        List<Post> posts = createPost(5);
        List<Post> savedPosts = new LinkedList<>();

        //when
        for (Post post : posts)
            savedPosts.add(postDao.save(post));

        //then
        assertThat(savedPosts.size()).isEqualTo(5);
    }

    private List<Post> createPost(int num) {
        List<Post> posts = new ArrayList<>(num);

        while (num-- > 0) {
            posts.add(Post.builder()
                    .title("test post title" + num)
                    .content("1. test\n2. test\n3. test")
                    .imgPath("test img path")
                    .expirationDate(LocalDateTime.now().plusDays(3L))
                    .needConditions(Long.parseLong("00111111111111111101111111111111111111111", 2))
                    .needDocuments(Long.parseLong("00111111111111111101111111111111111111111", 2))
                    .procedure("test procedure")
                    .build()
            );
        }
        return posts;
    }
}
