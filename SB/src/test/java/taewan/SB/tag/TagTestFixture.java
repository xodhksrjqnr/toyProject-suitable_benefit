package taewan.SB.tag;

import taewan.SB.dto.tag.TagDto;
import taewan.SB.entity.Tag;

public class TagTestFixture {
    public static TagDto createTagDto(Long id, String name) {
        return new TagDto(createCompleteTag(id, name));
    }

    public static Tag createTag(String name) {
        return new Tag(name);
    }

    public static Tag createCompleteTag(String name) {
        return createCompleteTag(1L, name);
    }

    public static Tag createCompleteTag(Long id, String name) {
        Tag tag = new Tag(name);

        tag.update(id, name);
        return tag;
    }
}
