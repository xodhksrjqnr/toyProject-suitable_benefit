package taewan.SBadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
