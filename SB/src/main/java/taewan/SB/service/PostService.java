package taewan.SB.service;

import taewan.SB.dto.post.PostDetailInfoDto;
import taewan.SB.dto.post.PostSaveDto;
import taewan.SB.dto.post.PostSimpleInfoDto;

import java.util.List;

public interface PostService {
    public List<PostSimpleInfoDto> findAll(Integer cursor, Long filter);
    public List<PostDetailInfoDto> findAll();
    public PostDetailInfoDto findActiveOne(Long postId);
    public PostDetailInfoDto findOne(Long postId);
    public Long save(PostSaveDto postSaveDto);
    public void updateActivity(Long postId);
    public void delete(Long postId);
}
