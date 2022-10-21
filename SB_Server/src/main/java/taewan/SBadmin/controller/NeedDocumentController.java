package taewan.SBadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taewan.SBadmin.dao.NeedDocumentDao;
import taewan.SBadmin.entity.NeedDocument;

@RestController
public class NeedDocumentController {
    private final NeedDocumentDao needDocumentDao;

    @Autowired
    public NeedDocumentController(NeedDocumentDao needDocumentDao) {
        this.needDocumentDao = needDocumentDao;
    }

    @GetMapping("/tmpNeedDocuments")
    public void tmpUpload() {
        for (int i = 0; i < 64; i++) {
            NeedDocument tmp = new NeedDocument();
            tmp.setName("document" + i);
            needDocumentDao.save(tmp);
        }
    }
}
