package taewan.SBadmin.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);
    void deleteByPostId(Long postId);
    Slice<Post> findSliceBy(Pageable pageable);
    Post findPostByPostId(long postId);
    long count();
}
