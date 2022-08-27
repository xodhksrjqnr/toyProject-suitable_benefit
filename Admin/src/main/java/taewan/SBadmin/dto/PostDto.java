package taewan.SBadmin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
abstract class PostDto {
    private String title;
    private String imgPath;
    private LocalDateTime expirationDate;

    public PostDto(String title, String imgPath, LocalDateTime expirationDate) {
        this.title = title;
        this.imgPath = imgPath;
        this.expirationDate = expirationDate;
    }
}
