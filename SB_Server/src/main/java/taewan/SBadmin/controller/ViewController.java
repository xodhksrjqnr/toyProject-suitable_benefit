package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.service.PostService;

import java.util.List;

@RestController
public class MainController {

    private final PostService postService;

    @Autowired
    public MainController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = {"posts/search/{page}", "posts/search"})
    @ResponseBody
    public List<PostSimpleInfoDto> search(@PathVariable(required = false) Integer page) {
        return postService.searchAll(page);
    }

    @GetMapping("posts/{postId}")
    @ResponseBody
    public PostFullInfoDto searchOne(@PathVariable Long postId) {
        return postService.searchOne(postId);
    }

    @PostMapping("posts/upload")
    public Long upload(PostSaveDto postSaveDto) {
        return postService.upload(postSaveDto);
    }

}
