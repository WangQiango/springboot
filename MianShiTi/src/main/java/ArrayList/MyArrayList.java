package main.java.ArrayList;

import java.util.Arrays;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    //空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //存放数据的数组
    private T[] elements;

    //数组的游标
    private int size = 0;

    public MyArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    //添加元素
    public void add (T element){
        add(size,element);
    }

    //指定索引位置添加元素
    public void add (int index , T element){
        if (checkSize()){
            resize();
        }
        //将index位置后面的元素全都向后移动一位
        for ( int i = size;i > index ; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size ++;
    }

    //指定位置元素賦值,返回原数据
    public T set (int index , T element){
        elements[index] = element;
        return null;
    }

    //获取指定位置的元素
    public T get(int index){
        return elements[index];
    }

    //移除指定位置的元素
    T remove(int index){
        for (int i = index ; i < size; i ++){
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
        return null;
    }

    //清空数组
    void clear(){
        elements = (T[]) EMPTY_ELEMENTDATA;
    }
    //判断数组是否需要扩容
    private boolean checkSize(){
        if (size+1>elements.length || elements == EMPTY_ELEMENTDATA){
            return true;
        }
        return false;
    }

    //数组扩容
    private void resize(){
        T[] newElements = (T[]) new Object[size*2];
        for (int i = 0 ; i < size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    //获取数组的大小
    int size(){
        return size;
    }

    @Override
    public String toString() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }

        return "MyArrayList{size=" + size +
                '}';
    }
}
