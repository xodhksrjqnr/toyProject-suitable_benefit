package taewan.SBadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dto.PostFullInfoDto;
import taewan.SBadmin.dto.PostSaveDto;
import taewan.SBadmin.dto.PostSimpleInfoDto;
import taewan.SBadmin.dto.PostUpdateDto;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Long upload(PostSaveDto postSaveDto) {
        PostFullInfoDto saved = postDao.save(postSaveDto);
        return saved.getPostId();
    }

    @Override
    public List<PostSimpleInfoDto> searchAll(Integer page) {
        return postDao.findAll(page != null ? page : 0);
    }

    @Override
    public PostFullInfoDto searchOne(Long postId) {
        return postDao.findOneByPostId(postId);
    }

    @Override
    public void remove(Long postId) {
        postDao.delete(postId);
    }

    @Override
    public void update(PostUpdateDto postUpdateDto) {
        postDao.modify(postUpdateDto);
    }
}
