package taewan.SBadmin.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class NeedCondition {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long conditionId;
    private String name;
}
