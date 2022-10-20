package taewan.SBadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.NeedDocument;

import java.util.List;

public interface NeedDocumentRepository extends JpaRepository<NeedDocument, Long> {
    NeedDocument save(NeedDocument needCondition);

    @Override
    List<NeedDocument> findAll();
}
