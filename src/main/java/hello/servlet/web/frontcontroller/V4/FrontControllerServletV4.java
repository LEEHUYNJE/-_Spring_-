package hello.servlet.web.frontcontroller.V4;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.V3.Controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.V3.Controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.V3.Controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.V3.ControllerV3;
import hello.servlet.web.frontcontroller.V4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.V4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.V4.controller.MemberSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerV1Map = new HashMap<>();

    public FrontControllerServletV4() {
        controllerV1Map.put("/front-controller/v4/members/new-form",new MemberFormControllerV4());
        controllerV1Map.put("/front-controller/v4/members/save",new MemberSaveControllerV4());
        controllerV1Map.put("/front-controller/v4/members",new MemberListControllerV4());

    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        ControllerV4 controller = controllerV1Map.get(requestURI);
        if(controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
         //paraMap을 연결해줘야함

        Map<String, String> paramMap = createParamMap(request);
        //모든 파라미터 이름(변수)들을 key값으로 맵에 넣고 다시 그 parameter(변수 값)울 찾아 hashMap형태로 저장한다.
        Map<String,Object> model = new HashMap<>() ;
        String viewName = controller.process(paramMap, model);


        MyView view = viewResolver(viewName);

        view.render(model,request,response);
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
