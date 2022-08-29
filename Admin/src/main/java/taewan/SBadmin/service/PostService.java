package taewan.SBadmin.service;

import taewan.SBadmin.dto.PostFullInfoDto;
import taewan.SBadmin.dto.PostSaveDto;
import taewan.SBadmin.dto.PostUpdateDto;

import java.util.List;

public interface PostService {

    public Long upload(PostSaveDto postSaveDto);

    public List<PostFullInfoDto> searchAll(Integer page);

    public PostFullInfoDto searchOne(Long postId);

    public void remove(Long postId);

    public void update(PostUpdateDto postUpdateDto);
}
