package com.blueboy.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 将配置文件中配置的值映射到这个组件中
 * @ConfigurationProperties 告诉springboot将这个类中的所有属性与配置文件中的相关配置进行绑定
 *          prefix = "person" 配置文件哪个下面的所有属性一一映射
 *
 *  只有这个组件是容器中的组件才能使用容器提供的@ConfigurationProperties功能，所以要加上@Component注解
 */
/**
 * @PropertySource只能用来读取指定的.properties的文件
 * 如果application.properties中有相同名称配置时还是会优先显示application中的数据
 */
//@PropertySource("classpath:person.properties")
@ConfigurationProperties(prefix = "person")
@Component
public class Person {

    private String name;
    private int age;
    private boolean isBoss;
    private HashMap maps;
    private ArrayList list;
    private Date birthday;
    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isBoss=" + isBoss +
                ", maps=" + maps +
                ", list=" + list +
                ", birthday=" + birthday +
                ", dog=" + dog +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }

    public HashMap getMaps() {
        return maps;
    }

    public void setMaps(HashMap maps) {
        this.maps = maps;
    }

    public ArrayList getList() {
        return list;
    }

    public void setList(ArrayList list) {
        this.list = list;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
