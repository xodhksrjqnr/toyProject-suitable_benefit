package taewan.SBadmin.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import taewan.SBadmin.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(nativeQuery = true, value = "select * from post where post_id >= :cursor limit 10")
    List<Post> findPostsAll(@Param("cursor") int cursor);
    @Query(nativeQuery = true,
            value = "select * from post where post_id >= :cursor and tags & :tags = :tags and activie = true limit 10")
    List<Post> findPostsAllByTags(@Param("cursor") int cursor, @Param("tags") long tags);
    @Query(nativeQuery = true,
            value = "select * from post where post_id >= :cursor and activity = true limit 10")
    List<Post> findActivityPostsAll(@Param("cursor") int cursor);
    @Modifying
    @Query("update Post p set p.activity = if(p.activity, false, true) where p.postId = :id")
    void modifyPostActivityByPostId(@Param("id") Long postId);
    long count();
}
