package com.blueboy.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("say")
    @ResponseBody
    public String say(@RequestBody String body){
        System.out.println(body);
        JSONObject jb = JSON.parseObject(body);
        return "hello " + 12;
    }
}
