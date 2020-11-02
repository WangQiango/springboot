package com.wangqiang.springboot;

public class Product {
    private String name;

    public void init(){
        System.out.println("执行了init方法");
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
