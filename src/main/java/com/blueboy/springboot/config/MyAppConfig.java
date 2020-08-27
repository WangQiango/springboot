package com.blueboy.springboot.config;

import com.blueboy.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类文件
 * @Configuration指明当前类是一个配置类，替代之前的Spring的配置文件
 *
 * 在配置文件中用bean标签添加组件，在此用@Bean注解添加组件
 */
@Configuration
public class MyAppConfig {
    //将方法的返回值添加到容器中，容器中这个组件的默认的id就是方法名儿
    @Bean
    public HelloService helloService(){
        System.out.println("配置类给容器中添加组件了");
        return new HelloService();
    }
}
