package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import taewan.SBadmin.dto.needDocument.NeedDocumentDto;
import taewan.SBadmin.entity.NeedDocument;
import taewan.SBadmin.repository.NeedDocumentRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Transactional
public class NeedDocumentDao {
    private Map<Long, String> registeredDocuments = new HashMap<>();
    private final NeedDocumentRepository needDocumentRepository;

    @Autowired
    public NeedDocumentDao(NeedDocumentRepository needDocumentRepository) {
        this.needDocumentRepository = needDocumentRepository;
        this.needDocumentRepository
                .findAll()
                .forEach(
                        condition -> registeredDocuments.put(
                                condition.getDocumentId(), condition.getName()
                        )
                );
    }

    public NeedDocumentDto save(NeedDocument needDocument) {
        return new NeedDocumentDto(needDocumentRepository.save(needDocument));
    }

    public List<String> findValidDocuments(long bitmap) {
        List<String> valid = new LinkedList<>();
        long index = 1;

        while (bitmap != 0) {
            if ((bitmap & 1) != 0)
                valid.add(registeredDocuments.get(index));
            index++;
            bitmap >>>= 1;
        }
        return valid;
    }
}
