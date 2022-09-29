package taewan.SBadmin.dto.post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.Post;

@Getter
@Setter
@ToString(callSuper = true)
public class PostFullInfoDto extends PostSimpleInfoDto {

    private String content;
    private Long needDocuments;
    private String url;

    public PostFullInfoDto(Post post) {
        super(post);
        this.content = post.getContent();
        this.needDocuments = post.getNeedDocuments();
        this.url = post.getUrl();
    }
}
