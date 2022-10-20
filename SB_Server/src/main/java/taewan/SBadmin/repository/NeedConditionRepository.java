package taewan.SBadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.NeedCondition;

import java.util.List;

public interface NeedConditionRepository extends JpaRepository<NeedCondition, Long> {
    NeedCondition save(NeedCondition needCondition);

    @Override
    List<NeedCondition> findAll();
}
