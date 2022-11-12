package taewan.SBadmin.tag;

import taewan.SBadmin.entity.Tag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TagUtils {
    public static Tag createTag(int index) {
        Tag tag = new Tag(index + "tag");
        return tag;
    }

    public static Tag createCompleteTag(int index) {
        Tag tag = createTag(index);
        tag.setTagId((long)(index + 1));
        return tag;
    }

    public static List<Tag> createTags(int size) {
        List<Tag> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
            list.add(createTag(i));
        return list;
    }

    public static List<String> testFindValidTags(long bitmap, Map<Long, String> tagCache) {
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
}
