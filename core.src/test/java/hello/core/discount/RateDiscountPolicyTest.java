package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*; // 알트 엔터로 생략가능
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10%할인이 적용되어야 한다.") // 이름을 만들어줄 수 있음
    void vip_o(){
        Member member = new Member(1l, "memberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(1000);

    }

    @Test // 실패 케이스
    @DisplayName("Vip가 아니면 할인이 적용되지 않아야한다.")
    void vip_x(){
        Member member = new Member(2l, "memberVIP", Grade.VIP );

        int discount = discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(1000);
    }
}