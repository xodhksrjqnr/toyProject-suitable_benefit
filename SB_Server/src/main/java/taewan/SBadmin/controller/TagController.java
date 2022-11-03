package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dao.TagDao;
import taewan.SBadmin.dto.tag.TagDto;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagController {

    private final TagDao tagDao;

    @Autowired
    public TagController(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping
    public List<TagDto> searchAll() {
        return tagDao.searchAll();
    }

    @CrossOrigin(origins = "${admin.origins}")
    @PostMapping("/{name}")
    public Long upload(@PathVariable(required = true) String name) {
        return tagDao.save(name);
    }
}
