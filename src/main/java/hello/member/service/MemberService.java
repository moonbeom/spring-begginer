package hello.member.service;

import hello.member.domain.Member;
import hello.member.respository.MemberRepository;
import hello.member.respository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// 비즈니스 로직을 구현
public class MemberService {

private final MemberRepository memberRepository;

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
