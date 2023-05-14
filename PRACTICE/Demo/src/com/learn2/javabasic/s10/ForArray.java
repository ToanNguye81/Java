package com.learn2.javabasic.s10;

import java.util.Random;

public class ForArray {
    public static void newArrayList() {
        Random random = new Random();
        Integer[] arrayList = new Integer[10];

        // create random List
        for (int i = 0; i < 10; i++) {
            arrayList[i] = Integer.valueOf(random.nextInt());
        }

        // print
        for (int i = 0; i < arrayList.length; i++) {
            System.out.println(arrayList[i]);
        }
    }

    public static void main(String[] args) {
        newArrayList();
    }
}