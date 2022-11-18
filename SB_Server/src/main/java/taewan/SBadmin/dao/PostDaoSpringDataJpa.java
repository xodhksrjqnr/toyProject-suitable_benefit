package taewan.SBadmin.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.entity.Post;
import taewan.SBadmin.repository.PostRepository;

import java.util.Arrays;
import java.util.List;

public class PostDaoSpringDataJpa implements PostDao {
    private final PostRepository postRepository;

    @Autowired
    public PostDaoSpringDataJpa(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostSimpleInfoDto> findActiveAll(Integer cursor) {
        return Arrays.asList(postRepository
                .findActiveAll(cursor)
                .stream().map(PostSimpleInfoDto::new)
                .toArray(PostSimpleInfoDto[]::new));
    }

    public List<PostSimpleInfoDto> findActiveAll(Integer cursor, Long filter) {
        return Arrays.asList(postRepository
                .findActiveAll(cursor, filter)
                .stream().map(PostSimpleInfoDto::new)
                .toArray(PostSimpleInfoDto[]::new));
    }

    public List<PostFullInfoDto> findAll() {
        return Arrays.asList(postRepository
                .findAll(Sort.by(Sort.Direction.DESC, "postId"))
                .stream().map(PostFullInfoDto::new)
                .toArray(PostFullInfoDto[]::new));
    }

    public PostFullInfoDto findById(Long postId) {
        return new PostFullInfoDto(postRepository.findById(postId).orElseThrow());
    }

    public PostFullInfoDto save(PostSaveDto postSaveDto) {
        return new PostFullInfoDto(postRepository.save(new Post(postSaveDto)));
    }

    public void modifyActivity(Long postId) {
        postRepository.modifyActivityById(postId);
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}
