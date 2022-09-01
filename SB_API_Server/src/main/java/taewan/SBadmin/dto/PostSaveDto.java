package taewan.SBadmin.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class PostSaveDto extends PostDto {
    private String content;
    private Long needConditions;
    private Long needDocuments;
    private String procedure;

    public PostSaveDto(String title, String imgPath, String content, LocalDateTime expirationDate,
                       Long needConditions, Long needDocuments, String procedure) {
        super(title, imgPath, expirationDate);
        this.content = content;
        this.needConditions = needConditions;
        this.needDocuments = needDocuments;
        this.procedure = procedure;
    }
}
