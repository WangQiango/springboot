package com.spring.at.service;

import com.spring.at.dao.UserInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Scope
public class UserService {
   /* @Autowired
    @Qualifier(value = "userImpl2")
    private UserInter userInter;*/


    //@Resource   //根据属性注入
    @Resource(name = "userImpl")//根据属性和名称注入，等同于上面两个一起用
    private UserInter userInter;
    public void add() {
        System.out.println("service add");
        userInter.add();
    }
}
