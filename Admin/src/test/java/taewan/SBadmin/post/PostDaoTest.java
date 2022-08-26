package taewan.SBadmin.post;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Slice;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dto.PostSaveDto;
import taewan.SBadmin.dto.PostUpdateDto;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class PostDaoTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostDao postDao;
    Utils utils = new Utils();

    @Test
    public void 게시물저장테스트() {
        //given
        int size = 5;
        List<PostSaveDto> posts = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            posts.add(utils.createSaveDto(i));
        List<Post> savedPosts = new LinkedList<>();

        //when
        for (PostSaveDto post : posts)
            savedPosts.add(postDao.save(post));

        //then
        assertThat(savedPosts.size()).isEqualTo(size);
        for (int i = 0; i < size; i++) {
            Post post = new Post();
            post.init(posts.get(i));
            Post save = savedPosts.get(i);
            assertThat(post.toString()).isEqualTo(save.toString());
        }
    }

    @Test
    public void 게시물조회테스트bySlice() {
        //given
        int size = 18;
        List<PostSaveDto> posts = new ArrayList<>(18);
        for (int i = 0; i < size; i++)
            posts.add(utils.createSaveDto(size));

        for (PostSaveDto post : posts)
            postDao.save(post);

        //when
        Slice<Post> sliced1 = postDao.findAll(0);
        Slice<Post> sliced2 = postDao.findAll(1);

        //then
        assertThat(sliced1.getNumberOfElements()).isEqualTo(10);
        assertThat(sliced2.getNumberOfElements()).isEqualTo(size - 10);
    }

    @Test
    public void 게시물삭제테스트() {
        //given
        Post save = postDao.save(utils.createSaveDto(1));

        //when
        assertThat(postRepository.count()).isEqualTo(1);
        postDao.delete(save.getPostId());

        //then
        assertThat(postRepository.count()).isEqualTo(0);
    }

    @Test
    public void 게시물수정테스트() {
        //given
        Post saved = postDao.save(utils.createSaveDto(1));

        //when
        String str = saved.toString();
        PostUpdateDto post = utils.createUpdateDto(1, saved.getPostId());
        post.setContent(saved.getContent() + " diff");
        postDao.modify(post);

        //then
        assertThat(str).isNotEqualTo(postDao.findOneByPostID(post.getPostId()).toString());
    }


}
