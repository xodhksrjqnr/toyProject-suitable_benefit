package taewan.SBadmin.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import taewan.SBadmin.dto.post.PostDetailInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
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
        this.title = dto.getTitle();
        this.imgPath = dto.getImgPath();
        this.content = dto.getContent();
        this.url = dto.getUrl();
        this.expirationDate = dto.getExpirationDate();
        this.tags = dto.getTags();
        this.activity = dto.getActivity();
    }

    public void update(PostDetailInfoDto dto) {
        this.postId = dto.getPostId();
        this.title = dto.getTitle();
        this.imgPath = dto.getImgPath();
        this.content = dto.getContent();
        this.url = dto.getUrl();
        this.createdDate = dto.getCreatedDate();
        this.expirationDate = dto.getExpirationDate();
        this.tags = dto.getTags();
        this.activity = dto.getActivity();
    }
}
