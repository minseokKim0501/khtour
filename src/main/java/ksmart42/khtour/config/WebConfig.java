package ksmart42.khtour.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ksmart42.khtour.interceptor.CommonInterceptor;
import ksmart42.khtour.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
   
   private CommonInterceptor commonInterceptor;
   private LoginInterceptor loginInterceptor; 
   
   public WebConfig(CommonInterceptor commonInterceptor, LoginInterceptor loginInterceptor) {
      this.commonInterceptor = commonInterceptor;
      this.loginInterceptor = loginInterceptor;
   }
   
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      
      registry.addInterceptor(commonInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns("/css/**")
            .excludePathPatterns("/docs/**")
            .excludePathPatterns("/fonts/**")
            .excludePathPatterns("/images/**")
            .excludePathPatterns("/member/images/**")
            .excludePathPatterns("/js/**");
      
      registry.addInterceptor(loginInterceptor)
		      .addPathPatterns("/**")
		      .excludePathPatterns("/css/**")
		      .excludePathPatterns("/docs/**")
		      .excludePathPatterns("/fonts/**")
		      .excludePathPatterns("/images/**")
		      .excludePathPatterns("/js/**")
		      .excludePathPatterns("/member/images/**")
      		  .excludePathPatterns("/")
              .excludePathPatterns("/member/loginMain");
      
      
      WebMvcConfigurer.super.addInterceptors(registry);
   }

}