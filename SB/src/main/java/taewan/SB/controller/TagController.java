package taewan.SB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import taewan.SB.dto.tag.TagDto;
import taewan.SB.service.TagService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping
    public List<TagDto> searchAll() {
        return tagService.findAll();
    }

    @CrossOrigin(origins = "${admin.origins}")
    @PostMapping("/{name}")
    public void upload(@PathVariable(required = true) String name, HttpServletResponse response,
                       @Value("${admin.origins}") String redirectUrl) throws IOException {
        tagService.save(name);
        response.sendRedirect(redirectUrl);
    }
}
