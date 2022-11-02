package taewan.SBadmin.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private Long memberId;
    private String id;
    private String password;
    private String nickName;
    private String email;
    private Long tags;

    @Builder
    public MemberDto(String id, String password, String nickName, String email, Long tags) {
        this.id = id;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.tags = tags;
    }
}
