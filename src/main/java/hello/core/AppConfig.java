package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean OrderService -> new MemoryMemberRepository()
    // 모지? 싱글톤이 깨지는건가?? 라는 의문이 생길 수 있음

    // 그럼 call AppConfig.memberRepository가 3번은 나오겠지? 했는데 출력결과는
    /*
        call AppConfig.memberService
        call AppConfig.orderService
        call AppConfig.orderService
        가 한번 씩 출력되었다...!
     */

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }


    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();    // 나중에 뭔가 변경이 있으면 이쪽만 바꾸면 끝!
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();     // 할인정책도 바뀌면 여기만 바꾸면 된다!
        return new RateDiscountPolicy();     // 할인정책도 바뀌면 여기만 바꾸면 된다!
    }
}
