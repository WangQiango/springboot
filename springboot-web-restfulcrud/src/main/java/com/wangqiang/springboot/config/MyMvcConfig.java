package com.wangqiang.springboot.config;


import com.wangqiang.springboot.component.LoginHandlerInterceptor;
import com.wangqiang.springboot.dao.EmployeeDao;
import com.wangqiang.springboot.eneities.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 如果你想保留Spring Boot MVC功能，并且你想添加额外的 MVC配置（拦截器，格式化程序，视图控制器和其他功能），
 * 你可以添加自己的@Configuration类WebMvcConfigurer类但没有 @EnableWebMvc。如果您希望提供RequestMappingHandlerMapping，
 * RequestMappingHandlerAdapter或ExceptionHandlerExceptionResolver的自定义实例，
 * 则可以声明WebMvcRegistrationsAdapter实例以提供此类组件。
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置视图解析器
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("success");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/index.html").excludePathPatterns("/user/login").excludePathPatterns("/");
    }*/

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
         WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
             @Override
             public void addInterceptors(InterceptorRegistry registry) {
                 registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                         excludePathPatterns("/index.html").excludePathPatterns("/user/login").excludePathPatterns("/");
             }
             @Override
             public void addViewControllers(ViewControllerRegistry registry) {
                 //配置视图解析器
                 registry.addViewController("/").setViewName("index");
                 registry.addViewController("/index.html").setViewName("index");
                 registry.addViewController("/main.html").setViewName("success");
             }
         };
         return webMvcConfigurerAdapter;
    }

    @Bean
    public EmployeeDao employeeDao(){
        return new EmployeeDao();
    }

}

