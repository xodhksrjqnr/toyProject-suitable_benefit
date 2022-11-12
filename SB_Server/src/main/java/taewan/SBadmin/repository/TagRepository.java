package taewan.SBadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
