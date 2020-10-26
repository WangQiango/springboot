package com.spring.at.bean;
public class Book {
    private String name;

    public Book(){
        System.out.println("Book constructor");
    }

    public void initMethod(){
        System.out.println("initMethod 执行");
    }

    public void setName(String name) {
        this.name = name;
    }


    public void destroy(){
        System.out.println("Book Bean destroy!");
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
