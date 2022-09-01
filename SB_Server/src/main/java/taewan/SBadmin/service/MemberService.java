package taewan.SBadmin.service;

import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;

import java.util.List;

public interface MemberService {

    public Long upload(MemberDto memberDto);

    public List<MemberSimpleInfoDto> searchAll(Integer page);

    public MemberFullInfoDto searchOne(Long memberId);

    public void remove(Long memberId);

    public void update(MemberDto memberDto);
}
