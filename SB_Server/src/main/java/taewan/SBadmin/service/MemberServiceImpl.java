package taewan.SBadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taewan.SBadmin.dao.MemberDao;
import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public Long upload(MemberDto memberDto) {
        MemberFullInfoDto saved = memberDao.save(memberDto);
        return saved.getMemberId();
    }

    @Override
    public List<MemberSimpleInfoDto> searchAll(Integer page) {
        return memberDao.findAll(page != null ? page : 0);
    }

    @Override
    public MemberFullInfoDto searchOne(Long memberId) {
        return memberDao.findOneByMemberId(memberId);
    }

    @Override
    public void remove(Long memberId) {
        memberDao.delete(memberId);
    }

    @Override
    public void update(MemberDto memberUpdateDto) {
        memberDao.modify(memberUpdateDto);
    }
}
