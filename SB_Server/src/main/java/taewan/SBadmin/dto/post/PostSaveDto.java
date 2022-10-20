package taewan.SBadmin.dto.post;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@ToString(callSuper = true)
public class PostSaveDto extends PostDto {
    private String content;
    private Long needConditions;
    private Long needDocuments;
    private String url;

    public PostSaveDto(String title, String imgPath, String content, LocalDateTime expirationDate,
                       Long needConditions, Long needDocuments, String url) {
        super(title, imgPath, expirationDate);
        this.content = content;
        this.needConditions = needConditions;
        this.needDocuments = needDocuments;
        this.url = url;
    }
}
