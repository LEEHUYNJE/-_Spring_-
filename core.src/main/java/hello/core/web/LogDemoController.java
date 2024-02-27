package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor // 자동으로 final에 대한 생성자를 입력받는다.
public class LogDemoController {

    private final LongDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){ // 자바에서 http request 를 받을 수 있다.

        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);


        myLogger.log("controller test");
        logDemoService.logic("testid");
        return "OK";

    }
}
