package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

@Component
public class PostDAO {

    @Autowired
    PostRepository postRepository;

    public void save(Post post) {
        postRepository.save(post);
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}
