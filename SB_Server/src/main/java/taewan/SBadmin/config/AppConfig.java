package taewan.SBadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.dao.TagDao;
import taewan.SBadmin.dao.TagDaoSpringDataJpa;
import taewan.SBadmin.dao.PostDaoSpringDataJpa;
import taewan.SBadmin.repository.TagRepository;
import taewan.SBadmin.repository.PostRepository;
import taewan.SBadmin.service.PostService;
import taewan.SBadmin.service.PostServiceImpl;

@Configuration
public class AppConfig {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @Autowired
    public AppConfig(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Bean
    public PostDao postDao() {
        return new PostDaoSpringDataJpa(postRepository);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postDao(), tagDao());
    }

    @Bean
    public TagDao tagDao() {
        return new TagDaoSpringDataJpa(tagRepository);
    }
}
