package taewan.SBadmin.post;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import taewan.SBadmin.dao.PostDAO;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import java.time.LocalDateTime;

@DataJpaTest
public class PostDAOTest {

    @Autowired
    PostRepository postRepository;
    PostDAO postDAO = new PostDAO();

    @Test
    public void 게시물저장테스트() {
        //given
        Post post = Post.builder()
                .title("test post title")
                .content("1. test\n2. test\n3.test")
                .imgPath("test img path")
                .expirationDate(LocalDateTime.now().plusDays(3L))
                .needConditions(Long.parseLong("00111111111111111101111111111111111111111", 2))
                .build();

        //when
        postDAO.save(post);

        //then
    }
}
