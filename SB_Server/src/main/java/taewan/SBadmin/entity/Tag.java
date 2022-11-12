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
@Setter
@ToString
@NoArgsConstructor
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    private String name;

    public Tag(String name) {
        this.name = name;
    }
}
