package taewan.SBadmin.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@SuperBuilder
public class PostUpdateDto extends PostSaveDto {
    private Long postId;

    public PostUpdateDto(Long postId, String title, String imgPath, String content, LocalDateTime expirationDate,
                         Long needConditions, Long needDocuments, String procedure) {
        super(title, imgPath, content, expirationDate, needConditions, needDocuments, procedure);
        this.postId = postId;
    }
}
