package hello.member.service;

import hello.member.domain.Member;
import hello.member.respository.MemberRepository;
import hello.member.respository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// 비즈니스 로직을 구현
 //서비스를 등록하고 Autowired를 작성해준다. 근데 얘는 생략이 가능하다. 스프링에서 사용하는 객체를 빈이라고 한다.
//스프링 컨테이너 안에서 bean을 만든다. 살아있는 클래스 객체로 즉 인스턴스화라고 생각하면 된다. 스프링에서 어노테이/션을 보고 만들어준다.

@Transactional
public class MemberService {

private final MemberRepository memberRepository;

 //이럴 경우 상호의존적인 레포지토리에 가서도 리포지토리를 작성해야한다.
public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
}
//    1. private final MemberRepository memberRepository =
//            new MemoryMemberRepository();

    // 회원 가입

    public Long join(Member member) {
     validateDuplicateMember(member);
     memberRepository.save(member);
     return member.getId();
    }
    //아이뒤 검증을 위해 validataDuplicateMember사용
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                   throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 회원 조회

    // 회원 전체 조회

}
