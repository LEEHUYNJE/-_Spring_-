package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS) // 고객의 요청이 들어와야 bean이 생성이 된다.
public class MyLogger {

    private String uuid;
    @Setter
    private String requestURL; // setter를 만들어 둿징

    public void log(String message){
        System.out.println("["+ uuid+ "]"+"["+requestURL+"] "+message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("["+ uuid+ "] request scope bean create" + this);
    }
    @PreDestroy
    public void close(){
        System.out.println("["+ uuid+ "] request scope bean close" + this);
    }

}
