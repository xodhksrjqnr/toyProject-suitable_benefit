package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dto.member.MemberFullInfoDto;
import taewan.SBadmin.dto.member.MemberDto;
import taewan.SBadmin.dto.member.MemberSimpleInfoDto;
import taewan.SBadmin.service.MemberService;

import java.util.List;

@RestController
@RequestMapping(value = "members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @CrossOrigin(origins = "${admin.origins}")
    @GetMapping(value = {"/{page}"})//api 중복 이후 처리
    public List<MemberSimpleInfoDto> searchAll(@PathVariable(required = false) Integer page) {
        return memberService.searchAll(page);
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping("/{memberId}")
    public MemberFullInfoDto searchOne(@PathVariable Long memberId) {
        return memberService.searchOne(memberId);
    }

    @CrossOrigin(origins = "${client.origins}")
    @PostMapping
    public void upload(MemberDto memberSaveDto) {
        memberService.upload(memberSaveDto);
    }
}
