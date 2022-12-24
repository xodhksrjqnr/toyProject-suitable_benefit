package taewan.SB.tag;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import taewan.SB.entity.Tag;
import taewan.SB.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TagRepositoryTest {
    @Autowired private TagRepository repository;

    @Test
    void 태그_저장() {
        //given
        Tag tag = new Tag("대학생");

        //when
        Tag saved = repository.save(tag);

        //then
        assertThat(saved.toString()).isEqualTo(tag.toString());
        assertThat(repository.count()).isOne();
    }

    @Test
    void 태그_전체조회() {
        //given
        int index = 5;
        List<Tag> tags = new ArrayList<>(5);

        for (int i = 0; i < index; i++)
            tags.add(new Tag("tag" + i));

        //when
        repository.saveAll(tags);
        List<Tag> found = repository.findAll();

        //then
        for (int i = 0; i < index; i++)
            assertThat(found.get(i).toString()).isEqualTo(tags.get(i).toString());
        assertThat(found.size()).isEqualTo(index);
    }
}
