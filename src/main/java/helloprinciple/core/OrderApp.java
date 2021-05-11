package helloprinciple.core;

import helloprinciple.core.member.Grade;
import helloprinciple.core.member.Member;
import helloprinciple.core.member.MemberSerivceImpl;
import helloprinciple.core.member.MemberService;
import helloprinciple.core.order.Order;
import helloprinciple.core.order.OrderService;
import helloprinciple.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberSerivceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
