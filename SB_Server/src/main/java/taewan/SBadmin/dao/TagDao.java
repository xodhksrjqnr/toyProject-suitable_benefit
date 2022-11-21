package taewan.SBadmin.dao;

import taewan.SBadmin.dto.tag.TagDto;

import java.util.List;

public interface TagDao {
    public TagDto save(String name);
    public List<TagDto> searchAll();
    public List<String> findValidTags(long bitmap);
    public void clearCache();
}
