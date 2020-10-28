package com.spring.at.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserImpl2 implements UserInter {
    public void add() {
        System.out.println("UserDao222222 add()");
    }
}
