package taewan.SBadmin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.dto.post.PostUpdateDto;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

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
        postRepository.deletePostByPostId(postId);
    }

    public List<PostSimpleInfoDto> findAll(int page) {
        List<PostSimpleInfoDto> converted = new LinkedList<>();
        postRepository
                .findPostsByVisible(createPageRequest(page), true)
                .forEach(post -> converted.add(new PostSimpleInfoDto(post)));
        return converted;
    }

    public List<PostSimpleInfoDto> findAll(int page, long filter) {
        List<PostSimpleInfoDto> converted = new LinkedList<>();
        postRepository
                .findPostsBytagsAndVisible(createPageRequest(page), filter, true)
                .forEach(post -> converted.add(new PostSimpleInfoDto(post)));
        return converted;
    }

    public List<PostFullInfoDto> findAllByAdmin(int page) {
        List<PostFullInfoDto> converted = new LinkedList<>();
        postRepository
                .findPostsBy(createPageRequest(page))
                .forEach(post -> converted.add(new PostFullInfoDto(post)));
        return converted;
    }

    private PageRequest createPageRequest(int page) {
        return PageRequest.of(page, 10);
    }

    public PostFullInfoDto findOneByPostId(long postId) {
        Post post = postRepository.findPostByPostId(postId);
        return post != null ? new PostFullInfoDto(post) : null;
    }

    public void modifyVisible(Long postId) {
        postRepository.modifyPostVisibleByPostId(postId);
    }

    public void modify(PostUpdateDto postUpdateDto) {
        Post post = postRepository.findPostByPostId(postUpdateDto.getPostId());
        post.init(postUpdateDto);
    }
}
