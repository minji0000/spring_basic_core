package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 전체를 설정하고 구성
// 실제 동작에 필요한 구현 객체를 생성
// 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결) 해준다.

// 관심사의 분리: 객체를 생성하고 연결하는 역할과 실행하는 역할이 명확히 분리되었다.
// 설정 정보
@Configuration
public class AppConfig {

    // 스프링 컨테이너에 등록하는 어노테이션
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");

        // 생성자 주입
        return new MemberServiceImpl(memberRepository());

    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");

        // 인터페이스를 상속받은 구현체들을 모두 생성자에 파라미터로 넣어줄 수 있나 ?
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        // return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }




}
