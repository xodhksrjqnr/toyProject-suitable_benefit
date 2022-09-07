package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.service.PostService;

import java.util.List;

@RestController
@CrossOrigin(origins = "${allowed.origins}")
@RequestMapping("posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = {"/search/{page}", "/search"})
    public List<PostSimpleInfoDto> search(@PathVariable(required = false) Integer page) {
        return postService.searchAll(page);
    }

    @GetMapping("/{postId}")
    public PostFullInfoDto searchOne(@PathVariable Long postId) {
        return postService.searchOne(postId);
    }

    @PostMapping("/upload")
    public Long upload(PostSaveDto postSaveDto) {
        return postService.upload(postSaveDto);
    }
}
