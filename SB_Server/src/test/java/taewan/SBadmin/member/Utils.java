package taewan.SBadmin.member;

import taewan.SBadmin.dto.member.MemberDto;

public class Utils {

    public MemberDto createMemberDto(int num) {
        return MemberDto.builder()
                .id("testId" + num)
                .password("password" + num)
                .nickName("nickName" + num)
                .email("test" + num + "@naver.com")
                .needConditions(3487598374598L)
                .build();
    }
}
