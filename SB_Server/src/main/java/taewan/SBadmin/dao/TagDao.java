package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import taewan.SBadmin.dto.tag.TagDto;
import taewan.SBadmin.entity.Tag;
import taewan.SBadmin.repository.TagRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Transactional
public class TagDao {
    private Map<Long, String> registeredTags = new HashMap<>();
    private final TagRepository tagRepository;

    @Autowired
    public TagDao(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
        this.tagRepository
                .findAll()
                .forEach(
                        tag -> registeredTags.put(
                                tag.getTagId(), tag.getName()
                        )
                );
    }

    public Long save(String name) {
        Tag saved = tagRepository.save(new Tag(name));
        registeredTags.put(saved.getTagId(), saved.getName());
        return saved.getTagId();
    }

    public List<TagDto> searchAll() {
        List<TagDto> found = new LinkedList<>();
        for (long key : registeredTags.keySet())
            found.add(new TagDto(key, registeredTags.get(key)));
        return found;
    }

    public List<String> findValidTags(long bitmap) {
        List<String> valid = new LinkedList<>();
        long index = 1;

        while (bitmap != 0) {
            if ((bitmap & 1) != 0)
                valid.add(registeredTags.get(index));
            index++;
            bitmap >>>= 1;
        }
        return valid;
    }
}