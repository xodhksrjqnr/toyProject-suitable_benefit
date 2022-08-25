package taewan.SBadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.SBadmin.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);
    void deleteByPostId(Long postId);
}
