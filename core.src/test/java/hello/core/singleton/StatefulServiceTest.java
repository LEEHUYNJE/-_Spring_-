package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("userA",10000);
        statefulService2.order("userB",20000);

        int price = statefulService1.getPrice(); //2만원이 나온다 왜? 같은 인스턴스를 2만원으로 설정해뒀기 때문이다
        Assertions.assertThat(statefulService1).isSameAs(statefulService2);
    }

    static class TestConfig {

        @Bean
        public  StatefulService statefulService(){
            return  new StatefulService();
        }
    }

}