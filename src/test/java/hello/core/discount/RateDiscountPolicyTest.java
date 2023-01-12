package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("정률 할인 VIP 성공 테스트")
    public void successVIPDiscountRate() {
        Member member = new Member(1L, "Member1", Grade.VIP);

        int discountPrice = discountPolicy.discount(member, 10000);

        Assertions.assertEquals(discountPrice, 1000);
    }

    @Test
    @DisplayName("정률 할인 BASIC 성공 테스트")
    public void successBASICDiscountRate() {
        Member member = new Member(1L, "Member1", Grade.BASIC);

        int discountPrice = discountPolicy.discount(member, 1000);

        Assertions.assertEquals(discountPrice, 0);
    }
}