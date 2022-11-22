package taewan.SBadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dao.TagDao;
import taewan.SBadmin.dto.post.PostDetailInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class PostServiceImpl implements PostService {

    private final PostDao postDao;
    private final TagDao tagDao;

    @Autowired
    public PostServiceImpl(PostDao postDao, TagDao tagDao) {
        this.postDao = postDao;
        this.tagDao = tagDao;
    }

    @Override
    public List<PostSimpleInfoDto> searchAll(Integer cursor, Long filter) {
        return (filter == 0L ? postDao.findActiveAll(cursor) : postDao.findActiveAll(cursor, filter));
    }

    @Override
    public List<PostDetailInfoDto> searchAll() {
        return postDao.findAll();
    }

    @Override
    public PostDetailInfoDto searchOne(Long postId) {
        return postDao.findById(postId);
    }

    @Transactional
    @Override
    public Long upload(PostSaveDto postSaveDto) {
        return postDao.save(postSaveDto).getPostId();
    }

    @Transactional
    @Override
    public void updateActivity(Long postId) {
        postDao.modifyActivity(postId);
    }

    @Transactional
    @Override
    public void remove(Long postId) {
        postDao.delete(postId);
    }
}
