package taewan.SBadmin.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String id;
    private String password;
    private String nickName;
    private String email;
    private Long needConditions;

    @Builder
    public MemberDto(String id, String password, String nickName, String email, Long needConditions) {
        this.id = id;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
        this.needConditions = needConditions;
    }
}
