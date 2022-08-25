package taewan.SBadmin.post;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import java.time.LocalDateTime;

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
        Post post = Post.builder()
                .title("test post title")
                .content("1. test\n2. test\n3. test")
                .imgPath("test img path")
                .expirationDate(LocalDateTime.now().plusDays(3L))
                .needConditions(Long.parseLong("00111111111111111101111111111111111111111", 2))
                .needDocuments(Long.parseLong("00111111111111111101111111111111111111111", 2))
                .procedure("test procedure")
                .build();

        //when
        Post save = postDao.save(post);

        //then
        assertThat(save.toString()).isEqualTo(post.toString());
    }
}
