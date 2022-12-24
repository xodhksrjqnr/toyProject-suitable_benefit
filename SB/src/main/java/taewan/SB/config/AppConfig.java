package taewan.SB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import taewan.SB.service.PostServiceImpl;
import taewan.SB.repository.TagRepository;
import taewan.SB.repository.PostRepository;
import taewan.SB.service.PostService;
import taewan.SB.service.TagService;
import taewan.SB.service.TagServiceImpl;

@Configuration
@EnableJpaAuditing
public class AppConfig {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @Autowired
    public AppConfig(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository, tagRepository);
    }

    @Bean
    public TagService tagService() {
        return new TagServiceImpl(tagRepository);
    }
}
