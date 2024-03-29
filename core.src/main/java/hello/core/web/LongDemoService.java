package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LongDemoService {

    private final MyLogger myLogger;
    public void logic(String testid) {

        myLogger.log("service id = "+ testid);
    }

}
