package taewan.SBadmin.post;

import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostUpdateDto;

import java.time.LocalDateTime;

public class Utils <T extends PostSaveDto> {

    public PostSaveDto createSaveDto(int num) {
        return PostSaveDto.builder()
                .title("test post title" + num)
                .content("1. test\n2. test\n3. test\n")
                .imgPath("test img path")
                .expirationDate(LocalDateTime.now().plusDays(3L))
                .needConditions(Long.parseLong("00111111111111111101111111111111111111111", 2))
                .needDocuments(Long.parseLong("00111111111111111101111111111111111111111", 2))
                .procedure("test procedure")
                .build();
    }

    public PostUpdateDto createUpdateDto(int num, long postId) {
        return PostUpdateDto.builder()
                .postId(postId)
                .title("test post title" + num)
                .content("1. test\n2. test\n3. test\n")
                .imgPath("test img path")
                .expirationDate(LocalDateTime.now().plusDays(3L))
                .needConditions(Long.parseLong("00111111111111111101111111111111111111111", 2))
                .needDocuments(Long.parseLong("00111111111111111101111111111111111111111", 2))
                .procedure("test procedure")
                .build();
    }
}
