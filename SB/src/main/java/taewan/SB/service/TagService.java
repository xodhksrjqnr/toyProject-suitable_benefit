package taewan.SB.service;

import taewan.SB.dto.tag.TagDto;

import java.util.List;

public interface TagService {
    List<TagDto> findAll();
    Long save(String name);
    void delete(Long tagId);
}
