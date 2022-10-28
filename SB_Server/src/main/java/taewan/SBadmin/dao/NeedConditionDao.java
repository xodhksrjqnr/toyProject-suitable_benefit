package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import taewan.SBadmin.dto.needCondition.NeedConditionDto;
import taewan.SBadmin.entity.NeedCondition;
import taewan.SBadmin.repository.NeedConditionRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Transactional
public class NeedConditionDao {
    private Map<Long, String> registeredConditions = new HashMap<>();
    private final NeedConditionRepository needConditionRepository;

    @Autowired
    public NeedConditionDao(NeedConditionRepository needConditionRepository) {
        this.needConditionRepository = needConditionRepository;
        this.needConditionRepository
                .findAll()
                .forEach(
                        condition -> registeredConditions.put(
                                condition.getConditionId(), condition.getName()
                        )
                );
    }

    public NeedConditionDto save(NeedCondition needCondition) {
        return new NeedConditionDto(needConditionRepository.save(needCondition));
    }

    public List<NeedConditionDto> searchAll() {
        List<NeedConditionDto> found = new LinkedList<>();
        for (long key : registeredConditions.keySet())
            found.add(new NeedConditionDto(key, registeredConditions.get(key)));
        return found;
    }

    public List<String> findValidConditions(long bitmap) {
        List<String> valid = new LinkedList<>();
        long index = 1;

        while (bitmap != 0) {
            if ((bitmap & 1) != 0)
                valid.add(registeredConditions.get(index));
            index++;
            bitmap >>>= 1;
        }
        return valid;
    }
}
