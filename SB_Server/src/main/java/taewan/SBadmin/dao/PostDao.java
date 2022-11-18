package taewan.SBadmin.dao;

import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;

import java.util.List;

public interface PostDao {
    public List<PostSimpleInfoDto> findActiveAll(Integer cursor);
    public List<PostSimpleInfoDto> findActiveAll(Integer cursor, Long filter);
    public List<PostFullInfoDto> findAll();
    public PostFullInfoDto findById(Long postId);
    public PostFullInfoDto save(PostSaveDto postSaveDto);
    public void modifyActivity(Long postId);
    public void delete(Long postId);
}
