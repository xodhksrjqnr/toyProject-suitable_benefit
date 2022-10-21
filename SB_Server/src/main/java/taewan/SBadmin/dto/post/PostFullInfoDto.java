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
    private Long needDocuments;
    private String url;
    private List<String> convertedConditions;
    private List<String> convertedDocuments;

    public PostFullInfoDto(Post post) {
        super(post);
        this.content = post.getContent();
        this.needDocuments = post.getNeedDocuments();
        this.url = post.getUrl();
    }
}
