package taewan.SBadmin.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import taewan.SBadmin.dto.post.PostSaveDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString(exclude = "postId")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String imgPath;
    private String content;
    private String url;
    @CreatedDate
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;
    private Long tags;
    private Boolean activity;

    public Post(PostSaveDto dto) {
        this.init(dto);
    }

    public void init(PostSaveDto dto) {
        this.title = dto.getTitle();
        this.imgPath = dto.getImgPath();
        this.content = dto.getContent();
        this.expirationDate = dto.getExpirationDate();
        this.tags = dto.getTags();
        this.url = dto.getUrl();
        this.activity = dto.getActivity();
    }
}
