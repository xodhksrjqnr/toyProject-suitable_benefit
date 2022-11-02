package taewan.SBadmin.dto.post;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@ToString
public class PostSaveDto {
    private String title;
    private String imgPath;
    private String content;
    private LocalDateTime expirationDate;
    private Long needConditions;
    private String url;
    private Boolean visible;

    public PostSaveDto(String title, String imgPath, String content, LocalDateTime expirationDate,
                       Long needConditions, String url) {
        this.title = title;
        this.imgPath = imgPath;
        this.expirationDate = expirationDate;
        this.content = content;
        this.needConditions = needConditions;
        this.url = url;
        this.visible = false;
    }
}
