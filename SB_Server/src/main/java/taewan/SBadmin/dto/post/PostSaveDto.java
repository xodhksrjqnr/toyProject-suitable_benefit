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
    private Long tags;
    private String url;
    private Boolean visible;

    public PostSaveDto(String title, String imgPath, String content, LocalDateTime expirationDate,
                       Long tags, String url) {
        this.title = title;
        this.imgPath = imgPath;
        this.expirationDate = expirationDate;
        this.content = content;
        this.tags = tags;
        this.url = url;
        this.visible = false;
    }
}
