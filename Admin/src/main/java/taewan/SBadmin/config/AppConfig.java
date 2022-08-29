package taewan.SBadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import taewan.SBadmin.controller.MainController;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.repository.PostRepository;
import taewan.SBadmin.service.PostService;
import taewan.SBadmin.service.PostServiceImpl;

@Configuration
public class AppConfig {

    private final PostRepository postRepository;

    @Autowired
    public AppConfig(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Bean
    public PostDao postDao() {
        return new PostDao(postRepository);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postDao());
    }

}
