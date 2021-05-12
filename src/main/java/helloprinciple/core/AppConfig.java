package helloprinciple.core;

import helloprinciple.core.discount.DiscountPolicy;
import helloprinciple.core.discount.RateDiscountPolicy;
import helloprinciple.core.member.MemberRepository;
import helloprinciple.core.member.MemberSerivceImpl;
import helloprinciple.core.member.MemberService;
import helloprinciple.core.member.MemoryMemberRepository;
import helloprinciple.core.order.OrderService;
import helloprinciple.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberSerivceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
