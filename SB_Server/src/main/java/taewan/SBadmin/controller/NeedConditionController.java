package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taewan.SBadmin.dao.NeedConditionDao;
import taewan.SBadmin.entity.NeedCondition;

@RestController
public class NeedConditionController {

    private final NeedConditionDao needConditionDao;

    @Autowired
    public NeedConditionController(NeedConditionDao needConditionDao) {
        this.needConditionDao = needConditionDao;
    }

    @GetMapping("/tmpNeedConditions")
    public void tmpUpload() {
        for (int i = 0; i < 64; i++) {
            NeedCondition tmp = new NeedCondition();
            tmp.setName("condition" + i);
            needConditionDao.save(tmp);
        }
    }
}
