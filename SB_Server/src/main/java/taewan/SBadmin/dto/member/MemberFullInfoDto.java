package taewan.SBadmin.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.Member;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(callSuper = true)
public class MemberFullInfoDto extends MemberSimpleInfoDto {

    private String id;
    private String password;
    private String email;
    private LocalDateTime createdDate;

    public MemberFullInfoDto(Member member) {
        super(member);
        this.id = member.getId();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.createdDate = member.getCreatedDate();
    }
}
