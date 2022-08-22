package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

@Component
public class PostDAO {

    @Autowired
    PostRepository postRepository;

    private void save(Post post) {
        postRepository.save(post);
    }

    private void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}
