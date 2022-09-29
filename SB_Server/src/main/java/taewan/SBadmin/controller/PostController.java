package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @CrossOrigin(origins = "${allowed.origins}")
    @GetMapping(value = {"/search/{page}", "/search"})
    public List<PostSimpleInfoDto> search(@PathVariable(required = false) Integer page) {
        return postService.searchAll(page);
    }

    @CrossOrigin(origins = "${allowed.origins}")
    @GetMapping("/{postId}")
    public PostFullInfoDto searchOne(@PathVariable Long postId) {
        return postService.searchOne(postId);
    }

    @PostMapping("/upload")
    @CrossOrigin(origins = "http://localhost:3001")
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
            String title = "title" + i;
            String imgPath = "https://www.next-t.co.kr/public/uploads/7b7f7e2138e29e598cd0cdf2c85ea08d.jpg";
            String content = "1.test를 위해 입력된 내용입니다./n2.내용의 형식은 대체로 같으며 게시물의 숫자에 따른 차이가 있습니다./n감사합니다." + i;
            String url = "https://test-url" + i + ".com";
            LocalDateTime expirationDate = LocalDateTime.now().plusDays(i + 1);
            Long needConditions = Math.abs(random.nextLong());
            Long needDocuments = Math.abs(random.nextLong());
            PostSaveDto postSaveDto = new PostSaveDto(title, imgPath, content, expirationDate, needConditions, needDocuments, url);
            postService.upload(postSaveDto);
        }
    }
}
