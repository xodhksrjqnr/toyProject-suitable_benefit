package taewan.SBadmin.dto.needCondition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import taewan.SBadmin.entity.NeedCondition;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NeedConditionDto {
    private Long conditionId;
    private String name;

    public NeedConditionDto(NeedCondition needCondition) {
        this.conditionId = needCondition.getConditionId();
        this.name = needCondition.getName();
    }

    public NeedConditionDto(Long conditionId, String name) {
        this.conditionId = conditionId;
        this.name = name;
    }
}
