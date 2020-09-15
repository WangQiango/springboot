package main.java.ArrayList;

import main.java.Dog;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Dog> arrayList = new MyArrayList<>();
        Dog dog = new Dog();
        dog.setAge("123");
        dog.setName("wwa");
        arrayList.add(dog);
        arrayList.add(dog);
        arrayList.add(dog);
        arrayList.add(dog);
        arrayList.add(dog);
//        arrayList.remove(2);
//        arrayList.add(2,123);
//        System.out.println(arrayList.get(2));
//        arrayList.set(2,123123);
        for (int i = 0; i < 1000; i++) {
            arrayList.add(dog);
        }
        System.out.println(arrayList.toString());
    }
}
