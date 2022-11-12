package taewan.SBadmin.tag;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TagUtils {
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
