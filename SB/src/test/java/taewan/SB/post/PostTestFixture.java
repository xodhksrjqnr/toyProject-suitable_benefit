package taewan.SB.post;

import taewan.SB.dto.post.PostDetailInfoDto;
import taewan.SB.dto.post.PostSaveDto;
import taewan.SB.entity.Post;

import java.time.LocalDateTime;

public class PostTestFixture<T> {
    public static PostSaveDto createDto(long index) {
        return createDto(index, 0L);
    }

    public static PostSaveDto createDto(long index, long tag) {
        return PostSaveDto.builder()
                .title("test title" + index)
                .content("test content" + index)
                .imgPath("http://test.com/img/" + index)
                .url("http://test.com/" + index)
                .expirationDate(LocalDateTime.now().plusDays(10))
                .tags(tag)
                .activity(false)
                .build();
    }

    public static PostDetailInfoDto createDetailDto(long index) {
        return createDetailDto(index, 0L);
    }

    public static PostDetailInfoDto createDetailDto(long index, long tag) {
        return PostDetailInfoDto.builder()
                .postId(index)
                .title("test title" + index)
                .content("test content" + index)
                .imgPath("http://test.com/img/" + index)
                .url("http://test.com/" + index)
                .createdDate(LocalDateTime.now())
                .expirationDate(LocalDateTime.now().plusDays(10))
                .tags(tag)
                .activity(false)
                .build();
    }

    public static Post createPost(long index) {
        return new Post(createDto(index, 0L));
    }

    public static Post createPost(long index, long tag) {
        return new Post(createDto(index, tag));
    }

    public static Post createCompletePost(long index) {
        Post post = new Post();

        post.update(createDetailDto(index, 0L));
        return post;
    }

    public static Post createCompletePost(long index, long tag) {
        Post post = new Post();

        post.update(createDetailDto(index, tag));
        return post;
    }
}
