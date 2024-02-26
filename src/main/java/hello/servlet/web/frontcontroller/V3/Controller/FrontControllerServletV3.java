package hello.servlet.web.frontcontroller.V3.Controller;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.V3.ControllerV3;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV1Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerV1Map.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerV1Map.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerV1Map.put("/front-controller/v3/members",new MemberListControllerV3());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerV1Map.get(requestURI);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
         //paraMap을 연결해줘야함

        Map<String, String> paramMap = createParamMap(request);
        //모든 파라미터 이름(변수)들을 key값으로 맵에 넣고 다시 그 parameter(변수 값)울 찾아 hashMap형태로 저장한다.
        ModelView mv = controller.process(paramMap);
        String viewName = mv.getViewName();

        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),request,response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String>  paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
