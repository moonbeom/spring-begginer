package hello.member.service;

import hello.member.domain.Member;
import hello.member.respository.MemberRepository;
import hello.member.respository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//
//class MemberServiceTest {
//    private final MemberRepository memberRepository =
//            new MemoryMemberRepository();

//}

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // 이 때 초기화하고 이 때 두개 생성
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("서문범");

        //when
        Long saveId = memberService.join(member);


        //then
        Member foundMember = memberRepository.findById(saveId).get();

        //검증하려면
        assertEquals("서문범", foundMember.getName());

    }

    @Test
    public void 중복회원예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("서문범");

        Member member2 = new Member();
        member2.setName("서문범");

        //when
        memberService.join(member1);

        //.class를 왜 붙이냐?
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


    }

}