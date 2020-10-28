package com.spring.at.bean;

public class User {
    private String name;
    public User(){
        System.out.println("User类被初始化加载成功............");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(){
        System.out.println("add........");
        System.out.println(name);
    }
}
