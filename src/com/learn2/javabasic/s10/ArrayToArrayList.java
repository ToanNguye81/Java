package com.learn2.javabasic.s10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayToArrayList {
    public static void arrayToArrayListExample() {
        String[] strings = new String[] { "a", "23", "ff", "d", "d" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        System.out.println(arrayList);// [a, 23, ff, d, d]
    }

    public static void arrayToArrayList1() {
        Integer[] arr = { 1, 2, 3, 4, 5, 89 };
        ArrayList<Integer> arrList = new ArrayList<>();
        Collections.addAll(arrList, arr);
        System.out.println(arrList);// [1, 2, 3, 4, 5, 89]
    }

    public static void arrayToArrayList2() {
        Integer[] arr = { 0, 3, 5, 6, 6, 32 };
        ArrayList<Integer> arrList3 = new ArrayList<>();
        for (Integer i : arr) {
            arrList3.add(i);
        }
        System.out.println(arrList3);// [0, 3, 5, 6, 6, 32]
    }

    public static void ToArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(16);
        arrayList2.add(11);
        arrayList2.add(14);
        arrayList2.add(116);
        Integer[] results = arrayList.stream().toArray(size -> new Integer[size]);
        Integer[] results2 = arrayList2.stream().toArray(Integer[]::new);// the same
        for (Integer i : results) {
            System.out.println(i + " ");
            /*
             * 1
             * 4
             * 16
             */
        }
        for (Integer i : results2) {
            System.out.println(i + " ");
            /*
             * 11
             * 14
             * 116
             */
        }
    }

    public static void main(String[] args) {
        arrayToArrayListExample();
        arrayToArrayList1();
        arrayToArrayList2();
        ToArray();
    }
}