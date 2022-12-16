package hello.member.respository;

import hello.member.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class MemoryMemberRepositoryTest {


    MemoryMemberRepository repository = new MemoryMemberRepository();

@AfterEach
    public void afterEach() {
    repository.clearStore();
}

    //
    @Test
    public void 저장테스트() {
        // given
        Member member = new Member();
        member.setName("서문범");

        // when
        repository.save(member);

        // then
       Member result = repository.findById(member.getId()).get();
       assertThat(result).isEqualTo(member);


    }

    @Test
    public void 이름찾기테스트() {
        Member member1 = new Member();
        member1.setName("이소영");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("김진욱");

        repository.save(member2);

        Member result = repository.findByName("이소영").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void 모두찾기테스트() {
        Member member1 = new Member();
        member1.setName("이소영");

        repository.save(member1);

        Member member2 = new Member();
        member2.setName("김진욱");

        repository.save(member2);
        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }

}