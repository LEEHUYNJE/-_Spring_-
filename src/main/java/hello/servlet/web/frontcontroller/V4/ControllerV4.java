package hello.servlet.web.frontcontroller.V4;

import java.util.Map;

/**
 * 
 */
public interface ControllerV4 {

    String process(Map<String,String> paraMap, Map<String,Object> model);
}
