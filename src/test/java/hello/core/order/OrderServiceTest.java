package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        orderService = appConfig.orderService();
        memberService = appConfig.memberService();
    }

    @Test
    public void creatOrder() {
        // given
        Long memberId = 1L;
        String memberName = "itemA";
        Member member = new Member(memberId, memberName, Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.creatOrder(memberId, "itemA", 10000);

        // then
        Assertions.assertEquals(order.getItemDiscount(), 1000);
        Assertions.assertEquals(order.calculatePrice(), 9000);

    }
}
