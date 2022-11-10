package taewan.SBadmin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import javax.transaction.Transactional;
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

    public PostFullInfoDto save(PostSaveDto postSaveDto) {
        return new PostFullInfoDto(postRepository.save(new Post(postSaveDto)));
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }

    public List<PostSimpleInfoDto> findAll(int cursor, long filter) {
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

    public PostFullInfoDto findOneByPostId(long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return new PostFullInfoDto(post.get());
    }

    public void modifyPostActivity(Long postId) {
        postRepository.modifyPostActivityByPostId(postId);
    }
}
