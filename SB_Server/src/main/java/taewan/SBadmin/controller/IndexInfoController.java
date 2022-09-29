package taewan.SBadmin.controller;

import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping(value = "indexInfo")
public class IndexInfoController {

    @Getter
    class Need {
        int key;
        String name;

        public Need(int key, String name) {
            this.key = key;
            this.name = name;
        }
    }

    @GetMapping("/needConditions")
    public Need[] validConditions() {
        Need[] valid = new Need[64];
        for (int i = 0; i < 64; i++)
            valid[i] = new Need(i, "condition" + i);
        return valid;
    }

    @GetMapping("/needDocuments")
    public Need[] validDocuments() {
        Need[] valid = new Need[64];
        for (int i = 0; i < 64; i++)
            valid[i] = new Need(i, "document" + i);
        return valid;
    }
}
