package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @스프링빈을 자동으로 등록해주는 어노테이션
@ComponentScan(
        // basePackages = "hello.core.member",
        // 필터를 사용하는 이유
        // 컴포넌트 스캔을 사용하면 앞에 Configuration이 붙은 설정정보도 자동으로 등록되므로
        // 앞서 (수동으로) 만들어둔 설정정보가 함께 등록되어 실행되어 버린다. (=충돌)
        // 그래서 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지는 않지만,
        // 기존 예제를 살리기 위해 여기선 이 방법을 선택했다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig  {

/*

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
*/

}
