package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberReopository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages = "hello.core.member", 지정하지 않으면 어떻게 되냐?
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
) //애노 테이션이 붙은 것들을 스프링 빈으로 등록시켜준다 // AppConifg를 빼고 등록시키기 위해서 이런짓을 한다.
public class AutoAppConfig { // autoAppConfig의 패키지가 시작 패키지가 된다.


}
