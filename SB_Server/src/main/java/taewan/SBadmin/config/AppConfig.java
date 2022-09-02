package taewan.SBadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import taewan.SBadmin.dao.MemberDao;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.repository.MemberRepository;
import taewan.SBadmin.repository.PostRepository;
import taewan.SBadmin.service.MemberService;
import taewan.SBadmin.service.MemberServiceImpl;
import taewan.SBadmin.service.PostService;
import taewan.SBadmin.service.PostServiceImpl;

@Configuration
public class AppConfig {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public AppConfig(PostRepository postRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @Bean
    public PostDao postDao() {
        return new PostDao(postRepository);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postDao());
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(memberRepository);
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberDao());
    }
}
