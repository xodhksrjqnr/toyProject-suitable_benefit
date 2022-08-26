package taewan.SBadmin.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@ToString
public class PostSaveDto {
    private String title;
    private String imgPath;
    private String content;
    private LocalDateTime expirationDate;
    private Long needConditions;
    private Long needDocuments;
    private String procedure;

    public PostSaveDto(String title, String imgPath, String content, LocalDateTime expirationDate,
                       Long needConditions, Long needDocuments, String procedure) {
        this.title = title;
        this.imgPath = imgPath;
        this.content = content;
        this.expirationDate = expirationDate;
        this.needConditions = needConditions;
        this.needDocuments = needDocuments;
        this.procedure = procedure;
    }
}
