package taewan.SBadmin.post;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import taewan.SBadmin.config.AppConfig;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.entity.Post;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class PostDaoTest {
    private ApplicationContext ac;
    private PostDao postDao;

    @BeforeTestClass
    public void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        postDao = ac.getBean(PostDao.class);
    }

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
        log.info(save.toString());
        log.info(post.toString());
    }
}
