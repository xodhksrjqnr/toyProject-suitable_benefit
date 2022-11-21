package taewan.SBadmin.dto.post;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class PostSaveDto {
    private String title;
    private String imgPath;
    private String content;
    private LocalDateTime expirationDate;
    private Long tags;
    private String url;
    private Boolean activity;
}