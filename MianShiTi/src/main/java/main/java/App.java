package main.java;

import HashMap.HashMap01;
import main.java.inte.Map;

public class App {
    public static void main(String[] args) {
        Map map = new HashMap01();
        map.put("刘一","刘一");
        map.put("陈二","陈二");
        map.put("张三","张三");
        map.put("李四","李四");
        map.put("王五","王五");
        map.put("王五","王五二比");
        map.put("wangqiang","wangqiang");
        System.out.println(map.get("王五"));
        System.out.println(map.size());
    }
}
