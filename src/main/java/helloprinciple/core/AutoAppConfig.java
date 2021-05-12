package helloprinciple.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)// @Component 애노테이션이 붙은 클래스를 모두 찾아 빈으로 등록해준다. 단 여기서는 @Configuration 애노테이션이 붙어있으면 수동으로 관리 해준다는 의미기 여기서는 때문에 제외한다. -> 기존 예제외 테스트 코드를 살리기 위하여...
public class AutoAppConfig {

}
