package taewan.SBadmin.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.Post;

@Getter
@Setter
@ToString
public class PostFullInfoDto extends PostSimpleInfoDto {

    private String content;
    private Long needDocuments;
    private String procedure;

    public PostFullInfoDto(Post post) {
        super(post);
        this.content = post.getContent();
        this.needDocuments = post.getNeedDocuments();
        this.procedure = post.getProcedure();
    }
}
