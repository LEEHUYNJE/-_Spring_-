package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
       // AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService(); // 멤버서비스 임플이 들어있음,메모리멤버리포지토리를 사용할것

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // 어노테이션은? 뭐임1
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// 컨피그에서 메서드를 꺼낸다.

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 등록

        Member findMEmber = memberService.findMember(1L);
        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMEmber.getName());
    }
}
