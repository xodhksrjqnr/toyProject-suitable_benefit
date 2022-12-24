package taewan.SB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import taewan.SB.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(nativeQuery = true,
            value = "select * from post where post_id = ?1 and activity = true")
    Optional<Post> findActiveOne(Long postId);
    @Query(nativeQuery = true,
            value = "select * from post where post_id > ?1 and tags & ?2 = ?2 and activity = true limit 10")
    List<Post> findActiveAll(Integer cursor, Long tags);
    @Modifying(clearAutomatically = true)
    @Query("update Post p set p.activity = if(p.activity, false, true) where p.postId = ?1")
    void modifyActivityById(Long postId);
}
