package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import taewan.SBadmin.dao.NeedConditionDao;
import taewan.SBadmin.dto.needCondition.NeedConditionDto;
import taewan.SBadmin.entity.NeedCondition;

import java.util.List;

@RestController
@RequestMapping("needConditions")
public class NeedConditionController {

    private final NeedConditionDao needConditionDao;

    @Autowired
    public NeedConditionController(NeedConditionDao needConditionDao) {
        this.needConditionDao = needConditionDao;
    }

    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    @GetMapping("/search")
    public List<NeedConditionDto> searchAll() {
        return needConditionDao.searchAll();
    }

    @CrossOrigin(origins = "${admin.origins}")
    @GetMapping("/upload/{name}")
    public Long upload(@PathVariable(required = true) String name) {
        return needConditionDao.save(name);
    }
}
