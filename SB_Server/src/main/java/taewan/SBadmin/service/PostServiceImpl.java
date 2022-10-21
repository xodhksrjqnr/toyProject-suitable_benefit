package taewan.SBadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taewan.SBadmin.dao.NeedConditionDao;
import taewan.SBadmin.dao.NeedDocumentDao;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dto.post.PostFullInfoDto;
import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.dto.post.PostSimpleInfoDto;
import taewan.SBadmin.dto.post.PostUpdateDto;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostDao postDao;
    private final NeedConditionDao needConditionDao;
    private final NeedDocumentDao needDocumentDao;

    @Autowired
    public PostServiceImpl(PostDao postDao, NeedConditionDao needConditionDao,
                           NeedDocumentDao needDocumentDao) {
        this.postDao = postDao;
        this.needConditionDao = needConditionDao;
        this.needDocumentDao = needDocumentDao;
    }

    @Override
    public Long upload(PostSaveDto postSaveDto) {
        PostFullInfoDto saved = postDao.save(postSaveDto);
        return saved.getPostId();
    }

    @Override
    public List<PostSimpleInfoDto> searchAll(Integer page) {
        return postDao.findAll(page);
    }

    @Override
    public PostFullInfoDto searchOne(Long postId) {
        PostFullInfoDto found = postDao.findOneByPostId(postId);
        found.setConvertedConditions(
                needConditionDao.findValidConditions(found.getNeedConditions())
        );
        found.setConvertedDocuments(
                needDocumentDao.findValidDocuments(found.getNeedDocuments())
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
