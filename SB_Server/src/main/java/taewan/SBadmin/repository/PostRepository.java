package taewan.SBadmin.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);
    void deletePostByPostId(Long postId);
    Slice<Post> findPostsBy(Pageable pageable);
    Slice<Post> findPostsByVisible(Pageable pageable, boolean visible);
    Slice<Post> findPostsByNeedConditionsAndVisible(Pageable pageable, long needConditions, boolean visible);
    Post findPostByPostId(long postId);
    long count();
}
