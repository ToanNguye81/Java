package com.learn3.javabasic.s10;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {
    String name;
    int age;
    double weight;
    long salary;
    String[] pets;

    // khởi tạo một tham sô name
    public Person(String name) {
        this.name = name;
        this.age = 45;
        this.weight = 23.4;
        this.salary = 12453533;
        this.pets = new String[] { "Cat", "Husky", "My Dog" };
    };

    // khởi tạo với tất cả tham số
    public Person(String name, int age, double weight, long salary, String[] pets) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.salary = salary;
        this.pets = pets;

    };

    // Khởi tạo không tham sô
    public Person() {
        this("Toàn");
    }

    // Khởi tạo với 3 tham số
    public Person(String name, int age, double weight) {
        this(name, age, weight, 2000000, new String[] { "Cat", "Dog", "Snake" });
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Person> arrayList = new ArrayList<>();
        // Khởi tạo các Person
        Person person1 = new Person();
        Person person2 = new Person("Toand");
        Person person3 = new Person("Some", 55, 343.4);
        Person person4 = new Person("Luu", 55, 343.4, 1214334, new String[] { "car", "toyora", "tokyo" });

        arrayList.add(person1);
        arrayList.add(person2);
        arrayList.add(person3);
        arrayList.add(person4);
        System.out.println(arrayList);
    }

    @Override
    public String toString() {
        return "Person = [name=" + name
                + ", age=" + age
                + ", weight=" + weight
                + ", salary=" + salary
                + ", pets=" + Arrays.toString(pets) + "]";
    }
}
