package com.spring.at.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository()
public class UserImpl implements UserInter {
    public void add() {
        System.out.println("UserDao add()");
    }
}
