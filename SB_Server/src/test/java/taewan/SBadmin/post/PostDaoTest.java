package taewan.SBadmin.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static taewan.SBadmin.post.PostUtils.*;

@SpringBootTest
public class PostDaoTest {
    @Autowired private PostRepository repository;
    @Autowired private PostDao postDao;

    @Transactional
    @Test
    void 게시물저장() {
        //given
        PostSaveDto dto = createDto(0);

        //when
        Long id = postDao.save(dto);

        //then
        assertThat(repository.count()).isEqualTo(1);
    }

    @Transactional
    @Test
    void 게시물삭제() {
        //given
        PostSaveDto dto = createDto(0);

        //when
        Long id = postDao.save(dto);

        //then
        assertThat(repository.count()).isEqualTo(1);
        postDao.delete(id);
        assertThat(repository.count()).isEqualTo(0);
    }

    @Transactional
    @Test
    void 게시물하나조회() {
        //given
        PostSaveDto dto = createDto(0);

        //when
        Long id = postDao.save(dto);

        //then
        //예외처리 후 진행
    }

    @Transactional
    @Test
    void 게시물공개여부변경() {
        //given
        PostSaveDto dto = createDto(0);

        //when
        Long id = postDao.save(dto);
        postDao.modifyPostActivity(id);

        //then
        assertThat(postDao.findOneByPostId(id).getActivity()).isTrue();
        postDao.modifyPostActivity(id);
        assertThat(postDao.findOneByPostId(id).getActivity()).isFalse();
    }

    @Transactional
    @Test
    void 공개게시물전체조회() {
        //given
        List<PostSaveDto> dtos = createDtos(5);
        List<Long> ids = new ArrayList<>(5);

        //when
        dtos.forEach(dto -> ids.add(postDao.save(dto)));
        ids.forEach(id -> postDao.modifyPostActivity(id));

        //then
        assertThat(postDao.findAll(0, 0L).size()).isEqualTo(5);
    }

    @Transactional
    @Test
    void 공개게시물전체조회with태그() {
        //given
        List<PostSaveDto> dtos = createDtos(5);
        List<Long> ids = new ArrayList<>(5);

        //when
        dtos.forEach(dto -> ids.add(postDao.save(dto)));
        ids.forEach(id -> postDao.modifyPostActivity(id));

        //then
        assertThat(postDao.findAll(0, 1L).size()).isEqualTo(1);
        assertThat(postDao.findAll(0, 32L).size()).isEqualTo(0);
    }

    @Transactional
    @Test
    void 게시물전체조회() {
        List<PostSaveDto> dtos = createDtos(5);
        List<Long> ids = new ArrayList<>(5);

        //when
        dtos.forEach(dto -> ids.add(postDao.save(dto)));
        ids.forEach(id -> postDao.modifyPostActivity(id));

        //then
        assertThat(postDao.findAll(0).size()).isEqualTo(5);
    }
}
