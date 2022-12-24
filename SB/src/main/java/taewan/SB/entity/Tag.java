package taewan.SB.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public void update(Long tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }
}
