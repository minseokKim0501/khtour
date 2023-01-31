package ksmart42.khtour.interceptor;

import java.util.Set;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class CommonInterceptor implements HandlerInterceptor{
   
   
   private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);
   
   /**
    * controller( == handle) 진입 전 실행되는 메소드
    * 
    */
   @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
         
         HandlerMethod method = null;
         if(handler instanceof HandlerMethod) {         
            method = (HandlerMethod) handler;
         }
         
         //ex:) memberEmail memberPw memberLevelCode
         Set<String> keySet = request.getParameterMap().keySet();
         
         //문자열마다 구분자를 넣는 클래스
         StringJoiner param = new StringJoiner(", ");
         
         //memberEmail: id001@email.com, memberPw: pw001
         for(String key : keySet) {
            param.add(key + ": " + request.getParameter(key));
         }
         
         log.info("CommonInterceptor =====================================START");
         log.info("ACCESS INFO =====================================START");
         log.info("PORT            	 ::::::      {}", request.getLocalPort());
         log.info("SERVER NAME       ::::::      {}", request.getServerName());
         log.info("HTTP METHOD       ::::::      {}", request.getMethod());
         log.info("URI           	 ::::::      {}", request.getRequestURI());
         if(method != null) {         
            log.info("Controller   	 ::::::      {}", method.getBean().getClass().getSimpleName());
         }
         log.info("PARAMETER     	 ::::::      {}", param);
         log.info("ACCESS INFO =====================================END");
         log.info("CommonInterceptor =====================================END");
         
         return true;
      }
   
   
}