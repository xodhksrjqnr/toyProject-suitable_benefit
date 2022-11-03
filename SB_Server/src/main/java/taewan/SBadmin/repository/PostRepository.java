package taewan.SBadmin.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import taewan.SBadmin.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);
    void deletePostByPostId(Long postId);
    Slice<Post> findPostsBy(Pageable pageable);
    Slice<Post> findPostsByActivity(Pageable pageable, boolean activity);
    Slice<Post> findPostsByTagsAndActivity(Pageable pageable, long tags, boolean activity);
    Post findPostByPostId(Long postId);
    @Modifying
    @Query(value = "update Post p set p.activity = if(p.activity, false, true) where p.postId = :postId")
    void modifyPostActByPostId(@Param("postId") Long postId);
    long count();
}
