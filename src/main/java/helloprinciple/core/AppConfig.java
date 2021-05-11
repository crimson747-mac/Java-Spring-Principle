package helloprinciple.core;

import helloprinciple.core.discount.FixDiscountPolicy;
import helloprinciple.core.member.MemberSerivceImpl;
import helloprinciple.core.member.MemberService;
import helloprinciple.core.member.MemoryMemberRepository;
import helloprinciple.core.order.OrderService;
import helloprinciple.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberSerivceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
