package taewan.SBadmin.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import taewan.SBadmin.dao.MemberDao;
import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;
import taewan.SBadmin.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberDaoTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberDao memberDao;
    Utils utils = new Utils();

    @Test
    public void 회원저장테스트() {
        //given
        MemberDto memberDto = utils.createMemberDto(1);

        //when
        MemberFullInfoDto saved = memberDao.save(memberDto);

        //then
        System.out.println(saved.toString());
        assertThat(saved.toString()).isEqualTo(memberDao.findOneByMemberId(saved.getMemberId()).toString());
    }

    @Test
    public void 회원조회테스트bySlice() {
        //given
        int size = 11;
        List<MemberDto> members = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
            members.add(utils.createMemberDto(i));
        for (MemberDto member : members)
            memberDao.save(member);

        //when
        List<MemberSimpleInfoDto> sliced1 = memberDao.findAll(0);
        List<MemberSimpleInfoDto> sliced2 = memberDao.findAll(1);

        //then
        assertThat(sliced1.size()).isEqualTo(10);
        assertThat(sliced2.size()).isEqualTo(size - 10);
    }

    @Test
    public void 회원단건조회테스트() {
        //given
        MemberFullInfoDto saved = memberDao.save(utils.createMemberDto(1));

        //when
        MemberFullInfoDto foundMember = memberDao.findOneByMemberId(saved.getMemberId());

        //then
        assertThat(foundMember.toString()).isEqualTo(saved.toString());
    }

    @Test
    public void 회원삭제테스트() {
        //given
        MemberFullInfoDto saved = memberDao.save(utils.createMemberDto(1));

        //when
        assertThat(memberRepository.count()).isEqualTo(1);
        memberDao.delete(saved.getMemberId());

        //then
        assertThat(memberRepository.count()).isEqualTo(0);
    }

    @Test
    public void 회원수정테스트() {
        //given
        MemberFullInfoDto saved = memberDao.save(utils.createMemberDto(1));

        //when
        Long pattern = saved.getConditions();
        MemberDto member = utils.createMemberDto(1);
        member.setMemberId(saved.getMemberId());
        member.setConditions(saved.getConditions() + 2);
        memberDao.modify(member);

        //then
        assertThat(pattern).isNotEqualTo(memberDao.findOneByMemberId(member.getMemberId()).getConditions());
    }
}
