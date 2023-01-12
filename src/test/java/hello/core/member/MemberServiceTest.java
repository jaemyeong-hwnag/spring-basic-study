package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "MemberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        // then
        // 타입 체크, 에러메시시 내용 같은 이유로 많이 사용안한다.
        Assertions.assertEquals(member.getName(), findmember.getName());
        Assertions.assertNotEquals(member.getName(), "name");
    }
}
