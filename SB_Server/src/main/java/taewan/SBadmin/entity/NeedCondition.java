package taewan.SBadmin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class NeedCondition {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conditionId;
    private String name;

    public NeedCondition(String name) {
        this.name = name;
    }
}
