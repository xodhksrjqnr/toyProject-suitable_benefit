package taewan.SBadmin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import taewan.SBadmin.dto.member.MemberDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberId;
    private String id;
    private String password;
    private String nickName;
    private String email;
    private Long needConditions;
    @CreatedDate
    private LocalDateTime createdDate;

    public Member(MemberDto dto) {
        this.init(dto);
    }

    public void init(MemberDto dto) {
        this.id = dto.getId();
        this.password = dto.getPassword();
        this.nickName = dto.getNickName();
        this.email = dto.getEmail();
        this.needConditions = dto.getNeedConditions();
    }
}
