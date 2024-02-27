package hello.springmvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {
    private ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonV1(@RequestBody String message) throws IOException {


        log.info("messageBody = {}",message);
        HelloData helloData = objectMapper.readValue(message, HelloData.class);

        log.info("username ={}, age={}",helloData.getUsername(),helloData.getAge());

        return "ok";

    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonV3(@RequestBody HelloData helloData) throws IOException {


        log.info("username ={}, age={}",helloData.getUsername(),helloData.getAge());

        return "ok";

    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyJsonV5(@RequestBody HelloData helloData) throws IOException {


        log.info("username ={}, age={}",helloData.getUsername(),helloData.getAge());

        return helloData;

    }

}
