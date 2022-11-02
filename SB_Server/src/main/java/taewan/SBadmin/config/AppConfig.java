package taewan.SBadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import taewan.SBadmin.dao.MemberDao;
import taewan.SBadmin.dao.TagDao;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.repository.MemberRepository;
import taewan.SBadmin.repository.TagRepository;
import taewan.SBadmin.repository.PostRepository;
import taewan.SBadmin.service.MemberService;
import taewan.SBadmin.service.MemberServiceImpl;
import taewan.SBadmin.service.PostService;
import taewan.SBadmin.service.PostServiceImpl;

@Configuration
public class AppConfig {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;

    @Autowired
    public AppConfig(PostRepository postRepository, MemberRepository memberRepository,
                     TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.tagRepository = tagRepository;
    }

    @Bean
    public PostDao postDao() {
        return new PostDao(postRepository);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postDao(), tagDao());
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(memberRepository);
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberDao());
    }

    @Bean
    public TagDao tagDao() {
        return new TagDao(tagRepository);
    }
}
