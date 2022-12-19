package hello.member;

import hello.member.respository.JpaMemberRepository;
import hello.member.respository.MemberRepository;
import hello.member.respository.MemoryMemberRepository;
import hello.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
//public class SpringConfig {
//    private final DataSource dataSource;
//    private final EntityManager em;
////
//    public SpringConfig(DataSource dataSource, EntityManager em) {
//        this.dataSource = dataSource;
//        this.em = em;
//    }
//
//        private final MemberRepository memberRepository;
//
//        public SpringConfig(MemberRepository memberRepository) {
//            this.memberRepository = memberRepository;
//        }

    public class SpringConfig {
        private final MemberRepository memberRepository;
        public SpringConfig(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
        }
        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository);
        }
    };

//        @Bean
//        public MemberService memberService() {
//            return new MemberService(memberRepository);
//        }

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository() {
//        return new JpaMemberRepository(em);
//    }
//}
