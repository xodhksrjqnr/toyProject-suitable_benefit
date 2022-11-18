package taewan.SBadmin.post;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import taewan.SBadmin.dao.PostDaoSpringDataJpa;
import taewan.SBadmin.dao.TagDaoSpringDataJpa;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.service.PostServiceImpl;
import taewan.SBadmin.tag.TagUtils;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static taewan.SBadmin.post.PostUtils.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock private TagDaoSpringDataJpa tagDao;
    @Mock private PostDaoSpringDataJpa postDao;
    @InjectMocks private PostServiceImpl postService;

    private static Map<Long, String> tagCache = new HashMap<>();

    @BeforeAll
    static void init() {
        for (long i = 0L; i < 50L; i++)
            tagCache.put(i, i + "tag");
    }

    @Test
    void 게시물저장() {
        //given
        PostSaveDto dto = createDto(0);
        PostFullInfoDto fullDto = new PostFullInfoDto(createCompletePost(0));
        when(postDao.save(any(PostSaveDto.class))).thenReturn(fullDto);

        //when
        Long id = postService.upload(dto);

        //then
        assertThat(id).isEqualTo(1L);
    }

    @Test
    void 게시물삭제() {
        //given
        PostSaveDto dto = createDto(0);
        PostFullInfoDto fullDto = new PostFullInfoDto(createCompletePost(0));
        when(postDao.save(any(PostSaveDto.class))).thenReturn(fullDto);

        //when
        Long id = postService.upload(dto);

        //then
        postService.remove(id);
    }

    @Test
    void 게시물단일조회() {
        //given
        PostSaveDto dto = createDto(0);
        PostFullInfoDto found = new PostFullInfoDto(createCompletePost(0));

        when(postDao.save(any(PostSaveDto.class))).thenReturn(found);
        when(postDao.findById(anyLong())).thenReturn(found);
        when(tagDao.findValidTags(anyLong()))
                .thenReturn(TagUtils.testFindValidTags(found.getTags(), tagCache));

        //when
        Long id = postService.upload(dto);

        //then
        assertThat(postService.searchOne(id).toString()).isEqualTo(found.toString());
    }

    @Test
    void 게시물공개여부변경() {
        //given
        PostSaveDto dto = createDto(0);
        PostFullInfoDto found = new PostFullInfoDto(createCompletePost(0));


        //when


        //then

    }

    @Test
    void 공개게시물전체조회() {

    }

    @Test
    void 공개게시물전체조회By태그() {

    }

    @Test
    void 게시물전체조회() {

    }
}
