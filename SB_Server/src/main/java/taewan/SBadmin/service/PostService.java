package taewan.SBadmin.service;

import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.dto.post.PostUpdateDto;

import java.util.List;

public interface PostService {

    public Long upload(PostSaveDto postSaveDto);

    public List<PostSimpleInfoDto> searchAll(Integer page, Long filter);

    public List<PostFullInfoDto> searchAll(Integer page);

    public PostFullInfoDto searchOne(Long postId);

    public void updateAct(Long postId);

    public void remove(Long postId);

    public void update(PostUpdateDto postUpdateDto);
}
