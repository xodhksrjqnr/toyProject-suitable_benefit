package taewan.SB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SB.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
