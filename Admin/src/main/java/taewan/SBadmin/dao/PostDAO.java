package taewan.SBadmin.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

@Slf4j
@Component
public class PostDAO {

    private PostRepository postRepository;

    @Autowired
    public PostDAO(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}
