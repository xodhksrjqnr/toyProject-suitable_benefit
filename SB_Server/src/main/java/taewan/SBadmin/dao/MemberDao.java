package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;
import taewan.SBadmin.entity.Member;
import taewan.SBadmin.repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Transactional
public class MemberDao {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberDao(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberFullInfoDto save(MemberDto postSaveDto) {
        return new MemberFullInfoDto(memberRepository.save(new Member(postSaveDto)));
    }

    public void delete(Long memberId) {
        memberRepository.deleteByMemberId(memberId);
    }

    public List<MemberSimpleInfoDto> findAll(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "createdDate"));
        List<MemberSimpleInfoDto> converted = new LinkedList<>();
        memberRepository
                .findAll(pageRequest)
                .forEach(member -> converted.add(new MemberSimpleInfoDto(member)));
        return converted;
    }

    public MemberFullInfoDto findOneByPostId(long memberId) {
        Member member = memberRepository.findMemberByMemberId(memberId);
        return member != null ? new MemberFullInfoDto(member) : null;
    }

    public void modify(MemberDto memberDto) {
        Member member = memberRepository.findMemberByMemberId(memberDto.getMemberId());
        member.init(memberDto);
    }
}
