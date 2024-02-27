package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={} age={}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody // return을 바디로 쏴준다.
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ){
        log.info("username={} age={}",memberName,memberAge);
        return "ok";

    }

    @ResponseBody // return을 바디로 쏴준다.
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String userName,
            @RequestParam int age
    ){
        log.info("username={} age={}",userName,age);
        return "ok";

    }
    @ResponseBody // return을 바디로 쏴준다.
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String userName,
            int age
    ){
        log.info("username={} age={}",userName,age);
        return "ok";

    }

    @ResponseBody // return을 바디로 쏴준다.
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) Integer age
    ){
        log.info("username={} age={}",userName,age);
        return "ok";

    }

    @ResponseBody // return을 바디로 쏴준다.
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(name = "username" , required = true, defaultValue = "guest") String userName,
            @RequestParam(required = false) Integer age
    ){
        log.info("username={} age={}",userName,age);
        return "ok";

    }

    /**
     * @RequestParam Map, MultiValueMap
     * Map(key=value)
     * MultiValueMap(key=[value1, value2, ...]) ex) (key=userIds, value=[id1, id2])
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"),
                paramMap.get("age"));
        return "ok";
    }



    /**
     * @ModelAttribute 사용
     * 참고: model.addAttribute(helloData) 코드도 함께 자동 적용됨, 뒤에 model을 설명할 때 자세히
    설명
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(),
                helloData.getAge());
        return "ok";
    }
}
