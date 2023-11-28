package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 컴포넌트 스캔 의존관계 자동 주입하기
@Configuration
@ComponentScan( // 컴포너트 스캔 @Component 애노테이션 붙은 클래스 스캔해서 스프링 빈으로 등록함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class) // Configuration 제외
)

public class AutoAppConfig {
}
