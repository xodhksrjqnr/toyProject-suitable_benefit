package taewan.SBadmin.tag;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import taewan.SBadmin.entity.Tag;
import taewan.SBadmin.repository.TagRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static taewan.SBadmin.tag.TagUtils.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TagRepositoryTest {
    @Autowired private TagRepository repository;

    @Test
    void 태그저장() {
        //given
        Tag tag = createTag(0);

        //when
        Tag saved = repository.save(tag);

        //then
        assertThat(saved.toString()).isEqualTo(tag.toString());
    }

    @Test
    void 태그전체조회() {
        //given
        List<Tag> tags = createTags(5);

        //when
        List<Tag> saved = repository.saveAll(tags);
        List<Tag> found = repository.findAll();

        //then
        for (int i = 0; i < 5; i++)
            assertThat(found.get(i).toString()).isEqualTo(saved.get(i).toString());
    }
}
