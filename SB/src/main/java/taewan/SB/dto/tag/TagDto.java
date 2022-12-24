package taewan.SB.dto.tag;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SB.entity.Tag;

@Getter
@Setter
@ToString
public class TagDto {
    private Long tagId;
    private String name;

    public TagDto(Tag tag) {
        this.tagId = tag.getTagId();
        this.name = tag.getName();
    }
}
