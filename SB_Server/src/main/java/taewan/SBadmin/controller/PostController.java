package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.service.PostService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping("/search/{page}")
    public List<PostSimpleInfoDto> search(@PathVariable Integer page) {
        return postService.searchAll(page);
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping("/{postId}")
    public PostFullInfoDto searchOne(@PathVariable Long postId) {
        return postService.searchOne(postId);
    }

    @PostMapping("/upload")
    @CrossOrigin(origins = "${client.origins}")
    public Long upload(PostSaveDto postSaveDto) {
        System.out.println(postSaveDto.toString());
        System.out.println(postSaveDto.getNeedDocuments().byteValue());
        return 10L;
//        return postService.upload(postSaveDto);
    }

    @GetMapping("/tmpupload/{num}")
    public void tmpUpload(@PathVariable int num) {
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            String title = "대학 생활비가 걱정일 땐?" + i;
            String imgPath = "https://www.ajou.ac.kr/_attach/ajou/editor-image/2021/05/GcOThbfNUXHsPQGUEbnqrcNCiT.jpg";
            String content = "1. 안정적인 학업여건 조성과 취업역량 제고를 위한 장학금입니다.\n" +
                    "2. 매 학기별 신청기간과 추가 신청기간이 존재합니다.\n" +
                    "3. (시급) 교내근로 9,160원, 교외근로 11,150원을 지원합니다.\n" +
                    "4. (최대근로시간) 1일 8시간 / 주당 학기중 20시간(방학중40시간) / 학기당 520시간입니다.";
            String url = "https://www.kosaf.go.kr/ko/scholar.do?pg=scholarship05_04_01";
            LocalDateTime expirationDate = LocalDateTime.now().plusDays(i + 1);
            Long needConditions = 1L;//Math.abs(random.nextLong());
            Long needDocuments = Math.abs(random.nextLong());
            PostSaveDto postSaveDto = new PostSaveDto(title, imgPath, content, expirationDate, needConditions, needDocuments, url);
            postService.upload(postSaveDto);
        }
    }
}
