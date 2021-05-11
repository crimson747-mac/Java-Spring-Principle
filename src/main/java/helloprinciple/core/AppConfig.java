package helloprinciple.core;

import helloprinciple.core.discount.DiscountPolicy;
import helloprinciple.core.discount.FixDiscountPolicy;
import helloprinciple.core.discount.RateDiscountPolicy;
import helloprinciple.core.member.MemberRepository;
import helloprinciple.core.member.MemberSerivceImpl;
import helloprinciple.core.member.MemberService;
import helloprinciple.core.member.MemoryMemberRepository;
import helloprinciple.core.order.OrderService;
import helloprinciple.core.order.OrderServiceImpl;

public class AppConfig {
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberSerivceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
