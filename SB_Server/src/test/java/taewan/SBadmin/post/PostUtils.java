package taewan.SBadmin.post;

import taewan.SBadmin.dto.post.PostSaveDto;
import taewan.SBadmin.entity.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostUtils {
    public static PostSaveDto createDto(int index) {
        return PostSaveDto.builder()
                .title("test title" + index)
                .content("test content" + index)
                .imgPath("http://test.com/img/" + index)
                .url("http://test.com/" + index)
                .expirationDate(LocalDateTime.now().plusDays(10))
                .tags((long)(1 << index))
                .activity(false)
                .build();
    }

    public static List<PostSaveDto> createDtos(int size) {
        List<PostSaveDto> dtos = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
            dtos.add(createDto(i));
        return dtos;
    }

    public static Post createPost(int index) {
        return new Post(createDto(index));
    }

    public static List<Post> createPosts(int size) {
        List<Post> posts = new ArrayList<>(size);

        createDtos(size).forEach(
                dto -> posts.add(createPost(dto))
        );
        return posts;
    }

    private static Post createPost(PostSaveDto dto) {
        return new Post(dto);
    }
}
