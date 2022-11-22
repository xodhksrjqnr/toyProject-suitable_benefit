package taewan.SBadmin.service;

import taewan.SBadmin.dto.post.PostDetailInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;

import java.util.List;

public interface PostService {
    public List<PostSimpleInfoDto> searchAll(Integer cursor, Long filter);
    public List<PostDetailInfoDto> searchAll();
    public PostDetailInfoDto searchOne(Long postId);
    public Long upload(PostSaveDto postSaveDto);
    public void updateActivity(Long postId);
    public void remove(Long postId);
}
