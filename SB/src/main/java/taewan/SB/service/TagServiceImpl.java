package taewan.SB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.SB.entity.Tag;
import taewan.SB.dto.tag.TagDto;
import taewan.SB.repository.TagRepository;

import java.util.Arrays;
import java.util.List;

@Transactional(readOnly = true)
@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<TagDto> findAll() {
        return Arrays.asList(tagRepository.findAll()
                .stream().map(TagDto::new)
                .toArray(TagDto[]::new));
    }

    @Transactional
    public Long save(String name) {
        Tag saved = tagRepository.save(new Tag(name));
        return saved.getTagId();
    }

    public void delete(Long tagId) {
        tagRepository.deleteById(tagId);
    }
}
