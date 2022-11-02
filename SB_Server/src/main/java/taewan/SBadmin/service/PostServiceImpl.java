package taewan.SBadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taewan.SBadmin.dao.TagDao;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.dto.post.PostUpdateDto;

import java.util.List;

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
    public Long upload(PostSaveDto postSaveDto) {
        PostFullInfoDto saved = postDao.save(postSaveDto);
        return saved.getPostId();
    }

    @Override
    public void modifyVisible(Long postId) {
        postDao.modifyVisible(postId);
    }

    @Override
    public List<PostSimpleInfoDto> searchAll(Integer page, Long filter) {
        if (filter != 0)
            return postDao.findAll(page, filter);
        return postDao.findAll(page);
    }

    @Override
    public List<PostFullInfoDto> searchAll(Integer page) {
        return postDao.findAllByAdmin(page);
    }

    @Override
    public PostFullInfoDto searchOne(Long postId) {
        PostFullInfoDto found = postDao.findOneByPostId(postId);
        found.setConvertedtags(
                tagDao.findValidTags(found.getTags())
        );
        return found;
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
