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
import taewan.SBadmin.service.PostService;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class PostServiceImplTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostDao postDao;
    @Autowired
    PostService postService;
    Utils utils = new Utils();

    @Test
    public void 게시물저장테스트() {
        //given
        int size = 5;

        //when
        for (int i = 0; i < size; i++)
            postService.upload(utils.createSaveDto(i));

        //then
        assertThat(postRepository.count()).isEqualTo(size);
    }

    @Test
    public void 게시물전체조회테스트() {
        //given
        int size = 15;

        for (int i = 0; i < size; i++)
            postService.upload(utils.createSaveDto(i));

        //when
        List<PostSimpleInfoDto> index1 = postService.searchAll(0);
        List<PostSimpleInfoDto> index2 = postService.searchAll(1);

        //then
        assertThat(index1.size()).isEqualTo(10);
        assertThat(index2.size()).isEqualTo(size - 10);
    }

    @Test
    public void 게시물단건조회테스트() {
        //given
        PostSaveDto post = utils.createSaveDto(1);

        //when
        Long postId = postService.upload(post);

        //then
        assertThat(postService.searchOne(postId)).isNotNull();
    }

    @Test
    public void 게시물삭제테스트() {
        //given
        PostSaveDto post = utils.createSaveDto(1);

        //when
        Long postId = postService.upload(post);
        postService.remove(postId);

        //then
        assertThat(postService.searchOne(postId)).isNull();
    }

    @Test
    public void 게시물수정테스트() {
        //given
        PostSaveDto post = utils.createSaveDto(1);

        //when
        PostFullInfoDto found = postService.searchOne(postService.upload(post));
        PostUpdateDto updateInfo = utils.createUpdateDto(1, found.getPostId());
        updateInfo.setContent(updateInfo.getContent() + "diff");
        postService.update(updateInfo);
        PostFullInfoDto modified = postService.searchOne(found.getPostId());

        //then
        assertThat(found.toString()).isNotEqualTo(modified.toString());
    }
}