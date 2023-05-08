package com.learn2.javabasic.s10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayToArrayList {
    public static void arrayToArrayListExample() {
        String[] strings = new String[] { "a", "23", "ff", "d", "d" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        System.out.println(arrayList);
    }

    public static void arrayToArrayList1() {
        Integer[] arr = { 1, 2, 3, 4, 5, 89 };
        ArrayList<Integer> arrList = new ArrayList<>();
        Collections.addAll(arrList, arr);
        System.out.println(arrList);
    }

    public static void main(String[] args) {
        arrayToArrayListExample();
        arrayToArrayList1();
    }
}