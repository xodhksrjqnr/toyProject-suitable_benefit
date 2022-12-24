package taewan.SB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.SB.entity.Tag;
import taewan.SB.dto.post.PostDetailInfoDto;
import taewan.SB.dto.post.PostSaveDto;
import taewan.SB.dto.post.PostSimpleInfoDto;
import taewan.SB.entity.Post;
import taewan.SB.repository.PostRepository;
import taewan.SB.repository.TagRepository;

import java.util.*;

@Transactional(readOnly = true)
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public List<PostSimpleInfoDto> findAll(Integer cursor, Long filter) {
        List<PostSimpleInfoDto> found = Arrays.asList(postRepository
                .findActiveAll(cursor, filter)
                .stream().map(PostSimpleInfoDto::new)
                .toArray(PostSimpleInfoDto[]::new));

        found.forEach(dto -> dto.setConvertedTags(findValidTags(dto.getTags())));
        return found;
    }

    @Override
    public List<PostDetailInfoDto> findAll() {
        List<PostDetailInfoDto> found = Arrays.asList(postRepository
                .findAll(Sort.by(Sort.Direction.DESC, "postId"))
                .stream().map(PostDetailInfoDto::new)
                .toArray(PostDetailInfoDto[]::new));

        found.forEach(dto -> dto.setConvertedTags(findValidTags(dto.getTags())));
        return found;
    }

    @Override
    public PostDetailInfoDto findActiveOne(Long postId) {
        PostDetailInfoDto found = new PostDetailInfoDto(
                postRepository.findActiveOne(postId).orElseThrow(
                        () -> new NoSuchElementException("비공개 게시물입니다.")));

        found.setConvertedTags(findValidTags(found.getTags()));
        return found;
    }

    @Override
    public PostDetailInfoDto findOne(Long postId) {
        PostDetailInfoDto found = new PostDetailInfoDto(
                postRepository.findById(postId).orElseThrow(
                        () -> new NoSuchElementException("존재하지 않는 게시물입니다.")));

        found.setConvertedTags(findValidTags(found.getTags()));
        return found;
    }

    @Transactional
    @Override
    public Long save(PostSaveDto postSaveDto) {
        Post saved = postRepository.save(new Post(postSaveDto));

        return saved.getPostId();
    }

    @Transactional
    @Override
    public void updateActivity(Long postId) {
        postRepository.modifyActivityById(postId);
    }

    @Transactional
    @Override
    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }

    private List<String> findValidTags(long bitmap) {
        List<String> valid = new ArrayList<>(Long.bitCount(bitmap));
        final List<Tag> tags = tagRepository.findAll();
        int index = 0;

        if (tags.size() != 0) {
            while (bitmap != 0) {
                if ((bitmap & 1) != 0)
                    valid.add(tags.get(index).getName());
                index++;
                bitmap >>>= 1;
            }
        }
        return valid;
    }
}
