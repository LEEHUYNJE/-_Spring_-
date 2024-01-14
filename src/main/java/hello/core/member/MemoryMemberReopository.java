package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberReopository implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>(); // '동시성 이슈'가 있으므로 다른 Map을 사용한다 실무에서는
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); // id (key값을 통해서 value를 찾는 과정)

    }
}
