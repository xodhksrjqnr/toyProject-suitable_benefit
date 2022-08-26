package taewan.SBadmin.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import taewan.SBadmin.dto.PostUpdateDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;

    private String title;
    private String imgPath;
    private String content;
    private int totalVote;
    private int positive;

    @CreatedDate
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;
    private Long needConditions;
    private Long needDocuments;
    private String procedure;

    public Post() {}

    public void init(PostUpdateDto postUpdateDto) {
        this.title = postUpdateDto.getTitle();
        this.imgPath = postUpdateDto.getImgPath();
        this.content = postUpdateDto.getContent();
        this.totalVote = 0;
        this.positive = 0;
        this.expirationDate = postUpdateDto.getExpirationDate();
        this.needConditions = postUpdateDto.getNeedConditions();
        this.needDocuments = postUpdateDto.getNeedDocuments();
        this.procedure = postUpdateDto.getProcedure();
    }
}
