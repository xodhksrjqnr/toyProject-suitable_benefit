package taewan.SBadmin.dto.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@ToString
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
