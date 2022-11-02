package taewan.SBadmin.dto.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.Post;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class PostFullInfoDto extends PostSimpleInfoDto {

    private String content;
    private String url;
    private List<String> convertedtags;

    public PostFullInfoDto(Post post) {
        super(post);
        this.content = post.getContent();
        this.url = post.getUrl();
    }
}
