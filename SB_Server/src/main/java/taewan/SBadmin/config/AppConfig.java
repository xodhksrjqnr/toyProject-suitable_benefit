package taewan.SBadmin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import taewan.SBadmin.dao.MemberDao;
import taewan.SBadmin.dao.NeedConditionDao;
import taewan.SBadmin.dao.NeedDocumentDao;
import taewan.SBadmin.dao.PostDao;
import taewan.SBadmin.repository.MemberRepository;
import taewan.SBadmin.repository.NeedConditionRepository;
import taewan.SBadmin.repository.NeedDocumentRepository;
import taewan.SBadmin.repository.PostRepository;
import taewan.SBadmin.service.MemberService;
import taewan.SBadmin.service.MemberServiceImpl;
import taewan.SBadmin.service.PostService;
import taewan.SBadmin.service.PostServiceImpl;

@Configuration
public class AppConfig {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final NeedConditionRepository needConditionRepository;
    private final NeedDocumentRepository needDocumentRepository;

    @Autowired
    public AppConfig(PostRepository postRepository, MemberRepository memberRepository,
                     NeedConditionRepository needConditionRepository, NeedDocumentRepository needDocumentRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.needConditionRepository = needConditionRepository;
        this.needDocumentRepository = needDocumentRepository;
    }

    @Bean
    public PostDao postDao() {
        return new PostDao(postRepository);
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postDao(), needConditionDao(), needDocumentDao());
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
    public NeedConditionDao needConditionDao() {
        return new NeedConditionDao(needConditionRepository);
    }

    @Bean
    public NeedDocumentDao needDocumentDao() {
        return new NeedDocumentDao(needDocumentRepository);
    }
}
