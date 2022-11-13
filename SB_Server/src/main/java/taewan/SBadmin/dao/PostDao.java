package taewan.SBadmin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Transactional
public class PostDao {
    private final PostRepository postRepository;

    @Autowired
    public PostDao (PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Long save(PostSaveDto postSaveDto) {
        return postRepository.save(new Post(postSaveDto)).getPostId();
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }

    public List<PostSimpleInfoDto> findAll(int cursor, Long filter) {
        List<PostSimpleInfoDto> converted = new LinkedList<>();
        (filter == 0L ? postRepository.findActivePostsAll(cursor) : postRepository.findActivePostsAll(cursor, filter))
                .forEach(post -> converted.add(new PostSimpleInfoDto(post)));
        return converted;
    }

    public List<PostFullInfoDto> findAll(int cursor) {
        List<PostFullInfoDto> converted = new LinkedList<>();
        postRepository.findPostsAll(cursor)
                .forEach(post -> converted.add(new PostFullInfoDto(post)));
        return converted;
    }

    public PostFullInfoDto findOneByPostId(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return new PostFullInfoDto(post.get());
    }

    public void modifyPostActivity(Long postId) {
        postRepository.modifyPostActivityByPostId(postId);
    }
}
