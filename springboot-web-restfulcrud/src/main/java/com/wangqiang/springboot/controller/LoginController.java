package com.wangqiang.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @PostMapping
    @GetMapping
//    @PutMapping
//    @DeleteMapping
    @RequestMapping(value = "/user/login" )
    public String login(@RequestParam("username")String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("user",username);
            map.put("user",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名密码错误");
            return "/index.html";
        }
    }
}
