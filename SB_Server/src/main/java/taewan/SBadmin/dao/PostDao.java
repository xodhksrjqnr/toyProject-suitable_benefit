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
                .findPostsByAct(PageRequest.of(page, 10), true)
                .forEach(post -> converted.add(new PostSimpleInfoDto(post)));
        return converted;
    }

    public List<PostSimpleInfoDto> findAll(int page, long filter) {
        List<PostSimpleInfoDto> converted = new LinkedList<>();
        postRepository
                .findPostsByTagsAndAct(PageRequest.of(page, 10), filter, true)
                .forEach(post -> converted.add(new PostSimpleInfoDto(post)));
        return converted;
    }

    public List<PostFullInfoDto> findAllByAdmin(int page) {
        List<PostFullInfoDto> converted = new LinkedList<>();
        postRepository
                .findPostsBy(PageRequest.of(page, 10))
                .forEach(post -> converted.add(new PostFullInfoDto(post)));
        return converted;
    }

    public PostFullInfoDto findOneByPostId(long postId) {
        Post post = postRepository.findPostByPostId(postId);
        return post != null ? new PostFullInfoDto(post) : null;
    }

    public void modifyPostAct(Long postId) {
        postRepository.modifyPostActByPostId(postId);
    }

    public void modify(PostUpdateDto postUpdateDto) {
        Post post = postRepository.findPostByPostId(postUpdateDto.getPostId());
        post.init(postUpdateDto);
    }
}
