package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;
import taewan.SBadmin.service.MemberService;

import java.util.List;

@RestController(value = "members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = {"search/{page}", "search"})
    public List<MemberSimpleInfoDto> search(@PathVariable(required = false) Integer page) {
        return memberService.searchAll(page);
    }

    @GetMapping("{memberId}")
    public MemberFullInfoDto searchOne(@PathVariable Long memberId) {
        return memberService.searchOne(memberId);
    }

    @PostMapping("upload")
    public Long upload(MemberDto memberSaveDto) {
        return memberService.upload(memberSaveDto);
    }
}
