package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 컨트롤러보다 공통 처리 가능한 스프링 인터셉터나 서블릿 필터 같은 곳 활용하는 것이 좋음
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger; // HTTP request 요청이 없어 빈 생존 범위가 아니라 오류 발생 - 고객 요청이 와야 생성, Provider 써서 해결
//    private final ObjectProvider<MyLogger> myLoggerProvider; // HTTP request 요청이 없어 빈 생존 범위가 아니라 오류 발생 - 고객 요청이 와야 생성, Provider 써서 해결

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) throws InterruptedException { // HttpServletRequest를 통해서 요청 URL받음
        String requestURL = request.getRequestURL().toString(); // 어떤 URL 요청했는지
//        MyLogger myLogger = myLoggerProvider.getObject();

        System.out.println("myLogger = " + myLogger.getClass()); // Spring이 조작한 MyLogger가 출력

        myLogger.setRequestURL(requestURL); // myLogger에 URL 저장 HTTP 요청당 구분되므로 섞이는 걱정 안해도 된다.

        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "OK";
    }
}
