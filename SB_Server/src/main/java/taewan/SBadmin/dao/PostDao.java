package taewan.SBadmin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.dto.post.PostUpdateDto;
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

    public List<PostSimpleInfoDto> findAll(int page, long filter) {
        List<PostSimpleInfoDto> converted = new LinkedList<>();
        if (filter == 0L) {
            find(postRepository.findPostsByActivity(PageRequest.of(page, 10), true))
                    .forEach(post -> converted.add(new PostSimpleInfoDto(post)));
        } else {
            find(postRepository.findPostsByTagsAndActivity(PageRequest.of(page, 10), filter, true))
                    .forEach(post -> converted.add(new PostSimpleInfoDto(post)));
        }
        return converted;
    }

    public List<PostFullInfoDto> findAll(int page) {
        List<PostFullInfoDto> converted = new LinkedList<>();
        find(postRepository.findPostsBy(PageRequest.of(page, 10)))
                .forEach(post -> converted.add(new PostFullInfoDto(post)));
        return converted;
    }

    private Slice<Post> find(Slice<Post> found) {
        return found;
    }

    public PostFullInfoDto findOneByPostId(long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.isPresent() ? new PostFullInfoDto(post.get()) : null;
    }

    public void modifyPostActivity(Long postId) {
        postRepository.modifyPostActivityByPostId(postId);
    }

    public void modify(PostUpdateDto postUpdateDto) {
        Optional<Post> post = postRepository.findById(postUpdateDto.getPostId());
        post.get().init(postUpdateDto);
    }
}
