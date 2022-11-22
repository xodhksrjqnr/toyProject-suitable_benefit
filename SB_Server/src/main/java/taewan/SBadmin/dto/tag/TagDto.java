package taewan.SBadmin.dto.tag;

import lombok.Getter;
import lombok.ToString;
import taewan.SBadmin.entity.Tag;

@Getter
@ToString
public class TagDto {
    private Long tagId;
    private String name;

    public TagDto(Long tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public TagDto(Tag tag) {
        this.tagId = tag.getTagId();
        this.name = tag.getName();
    }
}
