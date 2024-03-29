package hello.core;

import hello.core.discount.*;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberReopository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 멤버 서비스를 부르게 된다면, 생성자 주입.
    }
    @Bean
    public MemberRepository memberRepository() { // 메모리 멤버 리포지토리를 사용할거야
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberReopository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 여기서 구현체를 지정해줄 수있음
    }
    @Bean
    public DiscountPolicy discountPolicy(){ //할인 정책은 고정으로 할거야
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
