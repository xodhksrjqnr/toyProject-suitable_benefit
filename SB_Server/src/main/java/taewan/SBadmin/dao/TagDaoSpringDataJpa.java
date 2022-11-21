package taewan.SBadmin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import taewan.SBadmin.dto.tag.TagDto;
import taewan.SBadmin.entity.Tag;
import taewan.SBadmin.repository.TagRepository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TagDaoSpringDataJpa implements TagDao {
    private Map<Long, String> tagCache = new HashMap<>();
    private final TagRepository tagRepository;

    @Autowired
    public TagDaoSpringDataJpa(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
        this.tagRepository.findAll().forEach(
                        tag -> tagCache.put(tag.getTagId(), tag.getName()));
    }

    public TagDto save(String name) {
        TagDto saved = new TagDto(tagRepository.save(new Tag(name)));
        tagCache.put(saved.getTagId(), saved.getName());
        return saved;
    }

    public List<TagDto> searchAll() {
        List<TagDto> found = new LinkedList<>();
        for (long key : tagCache.keySet())
            found.add(new TagDto(key, tagCache.get(key)));
        return found;
    }

    public List<String> findValidTags(long bitmap) {
        List<String> valid = new LinkedList<>();
        long index = 1;

        while (bitmap != 0) {
            if ((bitmap & 1) != 0)
                valid.add(tagCache.get(index));
            index++;
            bitmap >>>= 1;
        }
        return valid;
    }

    public void clearCache() {
        this.tagCache.clear();
    }
}
