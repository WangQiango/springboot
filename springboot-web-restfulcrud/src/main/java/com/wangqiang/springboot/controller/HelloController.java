package com.wangqiang.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "helloWorld";
    }


    /**
     *  要使用模板引擎进行渲染的话，注解@ResponseBody就不能加，否则会直接返回到页面返回值
     *  返回的字符串会对应匹配到路径 classpath:/templates/success.html 的html文件。
     *
     */
//    @ResponseBody
    //查出一些数据在页面展示
    @RequestMapping("/success")
    public String success(Map map){
        map.put("hello","<h2>你好</h2>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu","zhaoliu"));
        return "success";
    }

}
