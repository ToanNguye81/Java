package com.learn3.javabasic.s10;

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

    };

    // Khởi tạo không tham sô
    public Person() {
        this("Toàn");
    }

    // Khởi tạo với 3 tham số
    public Person(String name, int age, double weight) {
        this(name, age, weight, 2000000, new String[] { "Cat", "Dog", "Snake" });
    }

    // public static void main(String[] args) throws Exception {
    // ArrayList<Person> arrayList = new ArrayList<>();
    // // Khởi tạo các Person
    // Person person1 = new Person();
    // Person person2 = new Person("Toand");
    // Person person3 = new Person();
    // Person person4 = new Person();
    // Person person5 = new Person();
    // arrayList.add(person1);
    // System.out.println(arrayList);
    // System.out.println(person2);

    // }

    @Override
    public String toString() {
        // String petStr = "[";
        // for (int i = 0; i < pets.length; i++) {
        // petStr += pets[i];
        // if (i < pets.length - 1) {
        // petStr += ", ";
        // }
        // }

        return "Person [name=" + name
                + ", age=" + age
                + ", weight=" + weight
                + ", salary=" + salary
                // + ", pets=" + petStr + "]";
                + ", pets=" + Arrays.toString(pets) + "]";
    }
}
