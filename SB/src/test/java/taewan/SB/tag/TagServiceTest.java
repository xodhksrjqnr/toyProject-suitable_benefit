package taewan.SB.tag;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import taewan.SB.dto.tag.TagDto;
import taewan.SB.entity.Tag;
import taewan.SB.repository.TagRepository;
import taewan.SB.service.TagServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static taewan.SB.tag.TagTestFixture.*;

@ExtendWith(MockitoExtension.class)
public class TagServiceTest {
    @Mock private TagRepository tagRepository;
    @InjectMocks private TagServiceImpl tagService;

    @Test
    public void 태그_저장() {
        //given
        String name = "태그1";
        Tag tag = createTag(name);
        Tag saved = createCompleteTag(name);

        when(tagRepository.save(tag)).thenReturn(saved);

        //when //then
        assertThat(tagService.save(name)).isEqualTo(1L);
        verify(tagRepository, times(1)).save(tag);
    }

    @Test
    public void 태그_삭제() {
        //given

        //when
        tagService.delete(1L);

        //then
        verify(tagRepository, times(1)).deleteById(1L);
    }

    @Test
    public void 태그_전체조회() {
        //given
        int index = 10;
        String name = "태그";
        List<Tag> saved = new ArrayList<>(index);

        for (int i = 0; i < index; i++)
            saved.add(createCompleteTag((long)(i + 1), name + i));
        when(tagRepository.findAll()).thenReturn(saved);

        //when
        List<TagDto> found = tagService.findAll();

        //then
        for (int i = 0; i < index; i++) {
            TagDto f = found.get(i);
            Tag s = saved.get(i);
            assertThat(f.getTagId()).isEqualTo(s.getTagId());
            assertThat(f.getName()).isEqualTo(s.getName());
            assertThat(f instanceof TagDto).isTrue();
        }

        verify(tagRepository, times(1)).findAll();
    }
}
