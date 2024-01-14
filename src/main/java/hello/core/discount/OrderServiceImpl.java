package hello.core.discount;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberReopository;

public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository; // 메모리맴버 리포지토리의 구현체로 생성
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy; // 할인 정책에 대해서 DIP를 지키고 있다. -> 추상화에 의존하고 있다.
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); // 맴버만 넘길지, grade만 넘길지는 고민해야함.


        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
