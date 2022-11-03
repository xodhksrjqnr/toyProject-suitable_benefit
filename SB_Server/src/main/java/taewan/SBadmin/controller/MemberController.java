package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;
import taewan.SBadmin.service.MemberService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
@RequestMapping(value = "members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{page}")//이후 사용시 api 중복 문제 해결
    public List<MemberSimpleInfoDto> search(@PathVariable Integer page) {
        return memberService.searchAll(page);
    }

    @GetMapping("/{memberId}")
    public MemberFullInfoDto searchOne(@PathVariable Long memberId) {
        return memberService.searchOne(memberId);
    }

    @PostMapping
    public Long upload(MemberDto memberSaveDto) {
        return memberService.upload(memberSaveDto);
    }
}
