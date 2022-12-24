package taewan.SB.dto.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import taewan.SB.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@ToString
public class PostSimpleInfoDto {
    private Long postId;
    private String title;
    private String imgPath;
    private LocalDateTime createdDate;
    private LocalDateTime expirationDate;
    private Boolean activity;
    private Long tags;
    private List<String> convertedTags;

    public PostSimpleInfoDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.imgPath = post.getImgPath();
        this.createdDate = post.getCreatedDate();
        this.expirationDate = post.getExpirationDate();
        this.tags = post.getTags();
        this.activity = post.getActivity();
    }
}
