package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import taewan.SBadmin.dto.needCondition.NeedConditionDto;
import taewan.SBadmin.entity.NeedCondition;
import taewan.SBadmin.repository.NeedConditionRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Transactional
public class NeedConditionDao {
    private NeedConditionRepository needConditionRepository;

    @Autowired
    public NeedConditionDao(NeedConditionRepository needConditionRepository) {
        this.needConditionRepository = needConditionRepository;
    }

    public NeedConditionDto save(NeedCondition needCondition) {
        return new NeedConditionDto(needConditionRepository.save(needCondition));
    }

    public Map<Long, String> findAll() {
        Map<Long, String> conditions = new HashMap<>();
        needConditionRepository
                .findAll()
                .forEach(
                        condition -> conditions.put(condition.getConditionId(), condition.getName())
                );
        return conditions;
    }
}
