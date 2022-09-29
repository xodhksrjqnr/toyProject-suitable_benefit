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
}
