package com.spring.at.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component：表示该类会被自动注入到IOC容器中 value值等同于bean标签的id属性
@Controller(value = "books")
public class Book {
    //@Value：给属性注入默认值
    @Value(value = "九阴真经")
    private String name;
    public Book(){
        System.out.println("Book constructor");
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
