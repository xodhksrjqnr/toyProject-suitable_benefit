package taewan.SBadmin.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import taewan.SBadmin.dto.post.PostSaveDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString(exclude = "postId")
@NoArgsConstructor
public class Post <T extends PostSaveDto> {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long postId;
    private String title;
    private String imgPath;
    private String content;
    private String url;
    @CreatedDate
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;
    private Long needConditions;
    private Long needDocuments;

    public Post(T dto) {
        this.init(dto);
    }

    public void init(T dto) {
        this.title = dto.getTitle();
        this.imgPath = dto.getImgPath();
        this.content = dto.getContent();
        this.expirationDate = dto.getExpirationDate();
        this.needConditions = dto.getNeedConditions();
        this.needDocuments = dto.getNeedDocuments();
        this.url = dto.getUrl();
    }
}
