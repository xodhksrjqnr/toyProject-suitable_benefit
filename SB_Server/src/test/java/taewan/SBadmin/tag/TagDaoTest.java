package taewan.SBadmin.tag;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import taewan.SBadmin.dao.TagDao;
import taewan.SBadmin.repository.TagRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TagDaoTest {
    @Autowired TagRepository repository;
    @Autowired
    TagDao tagDao;

    @Transactional
    @Test
    void 태그저장() {
        //given

        //when
        Long id = tagDao.save("대학생").getTagId();

        //then
        assertThat(repository.findById(id).isPresent()).isTrue();
    }

    @Transactional
    @Test
    void 태그전체조회() {
        //given
        String[] names = {"대학생", "취준생", "고등학생"};

        //when
        for (String name : names)
            tagDao.save(name);

        //then
        assertThat(tagDao.searchAll().size()).isEqualTo(3);
        tagDao.clearCache();
    }

    @Transactional
    @Test
    void 유효태그조회() {
        //given
        String[] names = {"대학생", "취준생", "고등학생"};

        //when
        for (String name : names)
            tagDao.save(name);

        //then
        List<String> valid = tagDao.findValidTags(1L);
        assertThat(valid.size()).isEqualTo(1);
        assertThat(valid.get(0)).isEqualTo("대학생");

        valid = tagDao.findValidTags(4L);
        assertThat(valid.size()).isEqualTo(1);
        assertThat(valid.get(0)).isEqualTo("고등학생");

        valid = tagDao.findValidTags(3L);
        assertThat(valid.size()).isEqualTo(2);
        assertThat(valid.get(0)).isEqualTo("대학생");
        assertThat(valid.get(1)).isEqualTo("취준생");
        tagDao.clearCache();
    }
}
