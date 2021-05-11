package helloprinciple.core.order;

import helloprinciple.core.member.Grade;
import helloprinciple.core.member.Member;
import helloprinciple.core.member.MemberSerivceImpl;
import helloprinciple.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberSerivceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDisCountPrice()).isEqualTo(1000);
    }
}
