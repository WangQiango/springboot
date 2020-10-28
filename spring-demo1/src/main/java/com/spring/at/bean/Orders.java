package com.spring.at.bean;


public class Orders {
    private String ID;
    private String num;

    public Orders(String id,String number){
        this.ID = id;
        this.num = number;
    }

    public Orders(String id){
        this.ID = id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID='" + ID + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
