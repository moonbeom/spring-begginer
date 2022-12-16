package hello.member.respository;

import hello.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //예외를 발생시키지 않으려고 썻다.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
