package taewan.SB.post;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import taewan.SB.dto.post.PostDetailInfoDto;
import taewan.SB.dto.post.PostSaveDto;
import taewan.SB.dto.post.PostSimpleInfoDto;
import taewan.SB.entity.Post;
import taewan.SB.entity.Tag;
import taewan.SB.repository.PostRepository;
import taewan.SB.repository.TagRepository;
import taewan.SB.service.PostServiceImpl;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static taewan.SB.tag.TagTestFixture.createCompleteTag;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock private TagRepository tagRepository;
    @Mock private PostRepository postRepository;
    @InjectMocks private PostServiceImpl postService;

    private static List<Tag> tags = new ArrayList<>(10);

    @BeforeAll
    static void init() {
        for (int i = 1; i <= 10; i++)
            tags.add(createCompleteTag((long)i, "태그" + i));
    }

    @Test
    void 게시물_저장() {
        //given
        PostSaveDto dto = PostTestFixture.createDto(1);
        Post saved = PostTestFixture.createCompletePost(1);

        when(postRepository.save(any(Post.class))).thenReturn(saved);

        //when //then
        assertThat(postService.save(dto)).isEqualTo(1L);
        verify(postRepository, times(1)).save(new Post(dto));
    }

    @Test
    void 게시물_삭제() {
        //given

        //when
        postService.delete(1L);

        //then
        verify(postRepository, atLeast(1)).deleteById(1L);
    }

    @Test
    void 게시물_단일조회() {
        //given
        when(postRepository.findById(1L))
                .thenReturn(Optional.of(PostTestFixture.createCompletePost(1L, 6L)));
        when(tagRepository.findAll()).thenReturn(tags);

        //when
        PostDetailInfoDto found = postService.findOne(1L);

        //then
        assertThat(found.getPostId()).isEqualTo(1L);
        assertThat(found.getConvertedTags().size()).isEqualTo(2);
        for (int i = 0; i < found.getConvertedTags().size(); i++)
            assertThat(found.getConvertedTags().get(i))
                    .isEqualTo(tags.get((int)Math.pow(2, i)).getName());
        verify(postRepository, times(1)).findById(1L);
        verify(tagRepository, times(1)).findAll();
    }

    @Test
    void 없는_게시물_단일조회() {
        //given
        when(postRepository.findById(1L)).thenReturn(Optional.empty());

        //when //then
        try {
            postService.findOne(1L);
        } catch (NoSuchElementException e) {
            assertThat(e.getMessage()).isEqualTo("존재하지 않는 게시물입니다.");
        }
        verify(postRepository, times(1)).findById(1L);
        verify(tagRepository, never()).findAll();
    }

    @Test
    void 공개게시물_단일조회() {
        //given
        PostDetailInfoDto dto = PostTestFixture.createDetailDto(1L, 6L);
        dto.setActivity(true);
        Post post = new Post();
        post.update(dto);

        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(tagRepository.findAll()).thenReturn(tags);

        //when
        PostDetailInfoDto found = postService.findOne(1L);

        //then
        assertThat(found.getPostId()).isEqualTo(1L);
        assertThat(found.getConvertedTags().size()).isEqualTo(2);
        assertThat(found.getActivity()).isTrue();
        for (int i = 0; i < found.getConvertedTags().size(); i++)
            assertThat(found.getConvertedTags().get(i))
                    .isEqualTo(tags.get((int)Math.pow(2, i)).getName());
        verify(postRepository, times(1)).findById(1L);
        verify(tagRepository, times(1)).findAll();
    }

    @Test
    void 비공개된_게시물에_대한_공개게시물_단일조회() {
        //given
        when(postRepository.findActiveOne(1L)).thenReturn(Optional.empty());

        //when //then
        try {
            postService.findActiveOne(1L);
        } catch (NoSuchElementException e) {
            assertThat(e.getMessage()).isEqualTo("비공개 게시물입니다.");
        }
        verify(postRepository, times(1)).findActiveOne(1L);
        verify(tagRepository, never()).findAll();
    }

    @Test
    void 게시물_공개여부변경() {
        //given


        //when
        postService.updateActivity(1L);

        //then
        verify(postRepository, times(1)).modifyActivityById(1L);
    }

    @Test
    void 공개게시물_전체조회with태그() {
        //given
        List<Post> posts = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Post post = new Post();
            post.update(PostTestFixture.createDetailDto(i, 2L));
            posts.add(post);
        }

        when(postRepository.findActiveAll(0, 2L)).thenReturn(posts);
        when(tagRepository.findAll()).thenReturn(tags);

        //when
        List<PostSimpleInfoDto> found = postService.findAll(0, 2L);

        //then
        for (PostSimpleInfoDto f : found) {
            assertThat(f instanceof PostSimpleInfoDto).isTrue();
            assertThat(f.getConvertedTags().get(0)).isEqualTo(tags.get(1).getName());
        }
        verify(postRepository, times(1)).findActiveAll(0, 2L);
        verify(tagRepository, times(10)).findAll();
    }

    @Test
    void 게시물_전체조회() {
        //given
        List<Post> posts = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Post post = new Post();
            post.update(PostTestFixture.createDetailDto(i));
            posts.add(post);
        }
        Collections.sort(posts, (o1, o2) -> {
            if (o1.getPostId() < o2.getPostId())
                return 1;
            return -1;
        });

        when(postRepository.findAll(Sort.by(Sort.Direction.DESC, "postId")))
                .thenReturn(posts);

        //when
        List<PostDetailInfoDto> found = postService.findAll();

        //then
        for (PostDetailInfoDto f : found)
            assertThat(f instanceof PostDetailInfoDto).isTrue();
        verify(postRepository, times(1))
                .findAll(Sort.by(Sort.Direction.DESC, "postId"));
        verify(tagRepository, times(10)).findAll();
    }

    @Test
    void 게시물_없는_경우_전체조회() {
        //given
        List<Post> post = new ArrayList<>();

        when(postRepository.findAll(Sort.by(Sort.Direction.DESC, "postId")))
                .thenReturn(List.of());

        //when //then
        assertThat(postService.findAll()).isEmpty();
        verify(postRepository, times(1))
                .findAll(Sort.by(Sort.Direction.DESC, "postId"));
        verify(tagRepository, never()).findAll();
    }
}
