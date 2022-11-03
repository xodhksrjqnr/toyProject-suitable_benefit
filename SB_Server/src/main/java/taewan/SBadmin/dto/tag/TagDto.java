package taewan.SBadmin.dto.tag;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TagDto {
    private Long tagId;
    private String name;

    public TagDto(Long tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }
}
