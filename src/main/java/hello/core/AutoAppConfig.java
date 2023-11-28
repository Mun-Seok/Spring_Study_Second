package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 컴포넌트 스캔 의존관계 자동 주입하기
@Configuration
@ComponentScan( // 컴포너트 스캔 @Component 애노테이션 붙은 클래스 스캔해서 스프링 빈으로 등록함
        basePackages = "hello.core", // 지정한 패키지부터 하위 패키지 찾음
        basePackageClasses = AutoAppConfig.class, // 지정 클래스 패키지 탐색 위치
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // Configuration 제외
)

public class AutoAppConfig {

    // 같은 빈 수동으로 등록 -> 수동 빈이 자동 빈 오버라이딩한다. but springboot가 수동 빈 자동 빈 등록시 오류, application.properties에서 바꿀 수 있음
/*    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
