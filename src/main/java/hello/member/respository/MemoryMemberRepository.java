package hello.member.respository;

import hello.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //저장할거는 멤버가된다.
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //key를 가져오면 됨.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

    @Override
    public Optional<Member> findByName(String name) {
//        Set<Long> keyset = store.keySet();  //이거를 먼저 알긴 알아야함.
//        //member들의 id가 전부 set에 담김.
//        Iterator<Long> id = keyset.iterator();
//        while (id.hasNext()) {
//            Member member = store.get(id.next());
//            if (name.equals(member.getName())) {
//                return Optional.ofNullable(member);
//            }
//        }

//        store.values().stream()    서문범 이소영 김진욱 이소영
//                .filter(member -> member.getName().equals(name)) 이소영 이소영
//                .findAny() 이소영
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
}
//        return Optional.ofNullable(null); 이거 바로위 리턴이랑 이어지는거임. 주석되어있는 리턴
