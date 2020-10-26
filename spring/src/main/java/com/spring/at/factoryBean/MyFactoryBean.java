package com.spring.at.factoryBean;

import com.spring.at.bean.Book;
import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Book> {
    //定义返回的bean
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setName("九阴真经");
        return book;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}
