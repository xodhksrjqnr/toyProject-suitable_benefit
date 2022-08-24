package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

@Component
public class PostDao {

    private final PostRepository postRepository;

    @Autowired
    public PostDao(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}