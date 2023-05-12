package com.learn4.javabasic.s10;

import java.util.ArrayList;

public class CMain {
    public static void main(String[] args) {
        CPet dog = new CDog(1, "Milo");
        CPet cat = new CCat(4, "Kathy");

        ArrayList<CPet> petsList = new ArrayList<>();
        petsList.add(dog);
        petsList.add(cat);

        CPerson person1 = new CPerson();
        CPerson person2 = new CPerson(1, 12, "Okama", "Hinata", petsList);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person2.getFirstName());
        System.out.println(person2.getLastName());
        System.out.println(person2.getAge());
    }
}
