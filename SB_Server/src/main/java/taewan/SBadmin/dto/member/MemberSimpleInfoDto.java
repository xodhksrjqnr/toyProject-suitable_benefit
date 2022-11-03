package taewan.SBadmin.dto.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.Member;

@Getter
@Setter
@ToString
public class MemberSimpleInfoDto {

    private Long memberId;
    private String nickName;
    private Long tags;

    public MemberSimpleInfoDto(Member member) {
        this.memberId = member.getMemberId();
        this.nickName = member.getNickName();
        this.tags = member.getTags();
    }
}
