package taewan.SBadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import taewan.SBadmin.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(nativeQuery = true, value = "select * from post where post_id >= ?1 limit 10")
    List<Post> findPostsAll(int cursor);
    @Query(nativeQuery = true,
            value = "select * from post where post_id >= ?1 and tags & ?2 = ?2 and activity = true limit 10")
    List<Post> findPostsAllByTags(int cursor, long tags);
    @Query(nativeQuery = true,
            value = "select * from post where post_id >= ?1 and activity = true limit 10")
    List<Post> findActivityPostsAll(int cursor);
    @Modifying
    @Query("update Post p set p.activity = if(p.activity, false, true) where p.postId = ?1")
    void modifyPostActivityByPostId(Long postId);
    long count();
}
