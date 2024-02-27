package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
  //  private final Logger log = LoggerFactory.getLogger(getClass()); lombok 으로 생략 가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);
        log.trace("trace log={}", name);
        // log.trace("trace log={} "+ name); 로하게 되면 ()내부의 연산을 먼저 실행하기때문에 자원낭비
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug("String concat log=" + name);

        return "ok";

    }
}

