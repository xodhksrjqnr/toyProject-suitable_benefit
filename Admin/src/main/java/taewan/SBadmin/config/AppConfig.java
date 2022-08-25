package taewan.SBadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.repository.PostRepository;

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
}
