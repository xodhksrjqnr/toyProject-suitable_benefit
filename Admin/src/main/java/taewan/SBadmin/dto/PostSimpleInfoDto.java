package taewan.SBadmin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.Post;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostSimpleInfoDto {

    private Long postId;
    private String title;
    private String imgPath;
    private int totalVote;
    private int positive;
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;
    private Long needConditions;

    public PostSimpleInfoDto(Post post) {
        this.title = post.getTitle();
        this.imgPath = post.getImgPath();
        this.postId = post.getPostId();
        this.totalVote = post.getTotalVote();
        this.positive = post.getPositive();
        this.createdDate = post.getCreatedDate();
        this.expirationDate = post.getExpirationDate();
        this.needConditions = post.getNeedConditions();
    }
}
