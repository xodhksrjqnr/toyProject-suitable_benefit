package taewan.SBadmin.dto.needCondition;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.NeedCondition;

@Getter
@Setter
@ToString
public class NeedConditionDto {
    private Long conditionId;
    private String name;

    public NeedConditionDto(NeedCondition needCondition) {
        this.conditionId = needCondition.getConditionId();
        this.name = needCondition.getName();
    }
}
