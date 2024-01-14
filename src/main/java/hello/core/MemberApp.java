package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // 멤버서비스 임플이 들어있음,메모리멤버리포지토리를 사용할것

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 등록

        Member findMEmber = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMEmber.getName());
    }
}
