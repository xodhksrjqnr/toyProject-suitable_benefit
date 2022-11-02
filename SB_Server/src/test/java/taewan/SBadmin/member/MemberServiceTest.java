package taewan.SBadmin.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taewan.SBadmin.dao.MemberDao;
import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;
import taewan.SBadmin.repository.MemberRepository;
import taewan.SBadmin.service.MemberService;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberDao memberDao;
    @Autowired
    MemberService memberService;
    Utils utils = new Utils();

    @Test
    public void 회원저장테스트() {
        //given
        int size = 5;

        //when
        for (int i = 0; i < size; i++)
            memberService.upload(utils.createMemberDto(i));

        //then
        assertThat(memberRepository.count()).isEqualTo(size);
    }

    @Test
    public void 회원전체조회테스트() {
        //given
        int size = 15;

        for (int i = 0; i < size; i++)
            memberService.upload(utils.createMemberDto(i));

        //when
        List<MemberSimpleInfoDto> index1 = memberService.searchAll(0);
        List<MemberSimpleInfoDto> index2 = memberService.searchAll(1);

        //then
        assertThat(index1.size()).isEqualTo(10);
        assertThat(index2.size()).isEqualTo(size - 10);
    }

    @Test
    public void 회원단건조회테스트() {
        //given
        MemberDto member = utils.createMemberDto(1);

        //when
        Long memberId = memberService.upload(member);

        //then
        assertThat(memberService.searchOne(memberId)).isNotNull();
    }

    @Test
    public void 회원삭제테스트() {
        //given
        MemberDto member = utils.createMemberDto(1);

        //when
        Long memberId = memberService.upload(member);
        memberService.remove(memberId);

        //then
        assertThat(memberService.searchOne(memberId)).isNull();
    }

    @Test
    public void 회원수정테스트() {
        //given
        MemberDto member = utils.createMemberDto(1);

        //when
        MemberFullInfoDto found = memberService.searchOne(memberService.upload(member));
        MemberDto updateInfo = utils.createMemberDto(1);
        updateInfo.setMemberId(found.getMemberId());
        updateInfo.setConditions(found.getConditions() + 2);
        memberService.update(updateInfo);
        MemberFullInfoDto modified = memberService.searchOne(found.getMemberId());

        //then
        assertThat(found.toString()).isNotEqualTo(modified.toString());
    }
}
