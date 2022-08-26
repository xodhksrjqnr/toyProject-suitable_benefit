package taewan.SBadmin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import taewan.SBadmin.dto.PostSaveDto;
import taewan.SBadmin.dto.PostUpdateDto;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import javax.transaction.Transactional;

@Transactional
public class PostDao {
    private final PostRepository postRepository;

    @Autowired
    public PostDao (PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(PostSaveDto postSaveDto) {
        Post post = new Post();
        post.init(postSaveDto);
        return postRepository.save(post);
    }

    public void delete(Long postId) {
        postRepository.deleteByPostId(postId);
    }

    public Slice<Post> findAll(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.by(Sort.Direction.ASC, "createdDate"));
        return postRepository.findAll(pageRequest);
    }

    public Post findOneByPostID(long postId) {
        return postRepository.findPostByPostId(postId);
    }

    public void modify(PostUpdateDto postUpdateDto) {
        Post post = findOneByPostID(postUpdateDto.getPostId());
        post.init(postUpdateDto);
    }
}
