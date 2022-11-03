package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.service.PostService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping("/{page}/{filter}")
    public List<PostSimpleInfoDto> searchAll(@PathVariable Integer page, @PathVariable Long filter) {
        return postService.searchAll(page, filter);
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping("/{postId}")
    public PostFullInfoDto searchOne(@PathVariable Long postId) {
        return postService.searchOne(postId);
    }

    @CrossOrigin(origins = "${admin.origins}")
    @PostMapping
    public void upload(PostSaveDto postSaveDto, HttpServletResponse response,
                       @Value("${admin.origins}") String redirectUrl) throws IOException {
        postService.upload(postSaveDto);
        response.sendRedirect(redirectUrl);
    }

    @CrossOrigin(origins = "${admin.origins}")
    @PostMapping("/{postId}/activity")
    public void updateActivity(@PathVariable Long postId) {
        postService.updateActivity(postId);
    }

    @CrossOrigin(origins = "${admin.origins}")
    @GetMapping("/{page}/detail")
    public List<PostFullInfoDto> searchAllDetail(@PathVariable Integer page) {
        return postService.searchAll(page);
    }
}
