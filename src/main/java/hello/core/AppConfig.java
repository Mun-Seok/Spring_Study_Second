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

@Configuration // 설정 정보를 나타냄
// 실제 동작에 필요한 구현 객체를 생성하고 생성자를 통해서 주입한다.
public class AppConfig {

    // @Bean memberService → new MemoryMemberRepository()
    // @Bean orderService → new MemoryMemberRepository()
    // 2번 호출되서 인스턴스 생성 → 싱글톤 패턴 깨짐?

    // 예상 memberRepository가 3번 호출해야 하지만 1번만 호출

    @Bean // 스프링 컨테이너에 등록됨
    public MemberService memberService() {
//        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
//        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // 정률 할인으로 변경
    }
}
