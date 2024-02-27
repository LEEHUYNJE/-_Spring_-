package hello.core.member;

public interface MemberService {
    void join(Member member); // member를 입력하면 id를 받고 회원이 되는 과정

    Member findMember(Long memberId); // id를 통해서 맴버를 반환하는 함수
}
