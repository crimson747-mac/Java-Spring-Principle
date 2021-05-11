package helloprinciple.core.order;

import helloprinciple.core.discount.DiscountPolicy;
import helloprinciple.core.discount.FixDiscountPolicy;
import helloprinciple.core.discount.RateDiscountPolicy;
import helloprinciple.core.member.Member;
import helloprinciple.core.member.MemberRepository;
import helloprinciple.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
