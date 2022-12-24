package taewan.SB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import taewan.SB.service.PostService;
import taewan.SB.dto.post.PostDetailInfoDto;
import taewan.SB.dto.post.PostSaveDto;
import taewan.SB.dto.post.PostSimpleInfoDto;

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
    @GetMapping("/{cursor}/{filter}")
    public List<PostSimpleInfoDto> searchAll(@PathVariable Integer cursor, @PathVariable Long filter) {
        return postService.findAll(cursor, filter);
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping("/{postId}")
    public PostDetailInfoDto searchOne(@PathVariable Long postId) {
        return postService.findOne(postId);
    }

    @CrossOrigin(origins = "${admin.origins}")
    @PostMapping
    public void upload(PostSaveDto postSaveDto, HttpServletResponse response,
                       @Value("${admin.origins}") String redirectUrl) throws IOException {
        postService.save(postSaveDto);
        response.sendRedirect(redirectUrl);
    }

    @CrossOrigin(origins = "${admin.origins}")
    @PostMapping("/{postId}/activity")
    public void updateActivity(@PathVariable Long postId) {
        postService.updateActivity(postId);
    }

    @CrossOrigin(origins = "${admin.origins}")
    @GetMapping("/detail")
    public List<PostDetailInfoDto> searchAllDetail() {
        return postService.findAll();
    }
}
