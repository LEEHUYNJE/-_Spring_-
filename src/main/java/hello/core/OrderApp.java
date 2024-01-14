package hello.core;

import hello.core.discount.Order;
import hello.core.discount.OrderService;
import hello.core.discount.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderApp { // 메인 메서드로 테스트는 좋지 않음
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); // 앱 컨 피그에서 생성
        OrderService orderService = appConfig.orderService();


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order); // to String 이라는 개념은 처음알게 됨 단축키는 알트 인설트
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
