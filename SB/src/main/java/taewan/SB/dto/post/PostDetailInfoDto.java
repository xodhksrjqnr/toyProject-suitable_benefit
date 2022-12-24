package taewan.SB.dto.post;

import lombok.*;
import lombok.experimental.SuperBuilder;
import taewan.SB.entity.Post;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class PostDetailInfoDto extends PostSimpleInfoDto {
    private String content;
    private String url;

    public PostDetailInfoDto(Post post) {
        super(post);
        this.content = post.getContent();
        this.url = post.getUrl();
    }
}
