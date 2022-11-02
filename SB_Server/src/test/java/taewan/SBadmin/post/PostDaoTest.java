package taewan.SBadmin.post;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.dto.post.PostUpdateDto;
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
        PostSaveDto post = utils.createSaveDto(1);

        //when
        PostFullInfoDto saved = postDao.save(post);

        //then
        assertThat(saved.toString()).isEqualTo(postDao.findOneByPostId(saved.getPostId()).toString());
    }

    @Test
    public void 게시물조회테스트bySlice() {
        //given
        int size = 18;
        List<PostSaveDto> posts = new ArrayList<>(18);

        for (int i = 0; i < size; i++)
            posts.add(utils.createSaveDto(i));
        for (PostSaveDto post : posts)
            postDao.save(post);

        //when
        List<PostSimpleInfoDto> sliced1 = postDao.findAll(0);
        List<PostSimpleInfoDto> sliced2 = postDao.findAll(1);

        //then
        assertThat(sliced1.size()).isEqualTo(10);
        assertThat(sliced2.size()).isEqualTo(size - 10);
    }

    @Test
    public void 게시물단건조회테스트() {
        //given
        PostFullInfoDto saved = postDao.save(utils.createSaveDto(1));

        //when
        PostFullInfoDto foundPost = postDao.findOneByPostId(saved.getPostId());

        //then
        assertThat(foundPost.toString()).isEqualTo(saved.toString());
    }

    @Test
    public void 게시물삭제테스트() {
        //given
        PostFullInfoDto save = postDao.save(utils.createSaveDto(1));

        //when
        assertThat(postRepository.count()).isEqualTo(1);
        postDao.delete(save.getPostId());

        //then
        assertThat(postRepository.count()).isEqualTo(0);
    }

    @Test
    public void 게시물수정테스트() {
        //given
        PostFullInfoDto saved = postDao.save(utils.createSaveDto(1));

        //when
        String str = saved.toString();
        PostUpdateDto post = utils.createUpdateDto(1, saved.getPostId());
//        post.setContent(saved.getContent() + " diff");
        postDao.modify(post);

        //then
        assertThat(str).isNotEqualTo(postDao.findOneByPostId(post.getPostId()).toString());
    }
}
