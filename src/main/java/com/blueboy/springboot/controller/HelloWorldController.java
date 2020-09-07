package com.blueboy.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

    //如果我们只需要在某个业务逻辑中获取一下配置文件中的某个值，就用@Value
    //如果我们专门编写了一个javaBean来和配置文件进行映射的话，那就直接使用@ConfigurationProperties；
//    @Value("${person.name}")
    private String name;
    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello World!";
    }

    @RequestMapping("sayHello")
    public String sayHello(){
        return "hello " + name;
    }
}
