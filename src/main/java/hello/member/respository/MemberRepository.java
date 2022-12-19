package hello.member.respository;

import hello.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { //인터페이스로 만들었기 때문에 교체가 쉽다.
    Member save(Member member);
    Optional<Member> findById(Long id); //예외를 발생시키지 않으려고 썻다.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
