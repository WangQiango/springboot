package com.spring.at.service;

import com.spring.at.dao.UserDaoInter;

public class UserService {

    private UserDaoInter UserDaoInter;

    public void setUserDaoImp(UserDaoInter UserDaoInter) {
        this.UserDaoInter = UserDaoInter;
    }

    public  void add(){
        System.out.println("service add");
        UserDaoInter.update();
    }

}