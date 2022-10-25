package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taewan.SBadmin.dao.NeedConditionDao;
import taewan.SBadmin.dto.needCondition.NeedConditionDto;
import taewan.SBadmin.entity.NeedCondition;

import java.util.List;

@RestController
public class NeedConditionController {

    private final NeedConditionDao needConditionDao;

    @Autowired
    public NeedConditionController(NeedConditionDao needConditionDao) {
        this.needConditionDao = needConditionDao;
    }

    @GetMapping("/needConditions/search")
    @CrossOrigin(origins = {"${admin.origins}", "${client.origins}"})
    public List<NeedConditionDto> searchAll() {
        return needConditionDao.searchAll();
    }
}
