package com.spring.at.autowire;

import sun.management.Agent;

public class Emp {

    private Dept dep;

    private String name;

    private int age;


    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dep +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Dept getDept() {
        return dep;
    }

    public void setDept(Dept dept) {
        this.dep = dept;
    }

    public  void test(){
        System.out.println(toString());
    }
}
