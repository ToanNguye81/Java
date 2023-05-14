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

    public static void toArray() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(16);

        arrayList2.add(11);
        arrayList2.add(116);
        arrayList2.add(14);
        arrayList2.add(116);
        arrayList2.add(118);

        Integer[] results = arrayList.stream().toArray(size -> new Integer[size]);
        Integer[] results2 = arrayList2.stream().toArray(Integer[]::new);// the same
        int[] results3 = arrayList.stream().mapToInt(i -> i).toArray();
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
        for (Integer i : results3) {
            System.out.println(" result 3 :" + i);
            /*
             * result 3 :1
             * result 3 :4
             * result 3 :16
             */
        }

        // Get last index of 116
        System.out.println(arrayList2.lastIndexOf(116));// 3

        // add element to index
        arrayList2.add(1, 125);
        arrayList2.add(127);
        System.out.println(arrayList2);// [11, 125, 116, 14, 116, 118, 127]

        // Remove element at index
        arrayList2.remove(3);
        System.out.println(arrayList2);// [11, 125, 116, 116, 118, 127]

        // Update element at index
        arrayList2.set(2, 66);
        System.out.println(arrayList2);// [11, 125, 116, 116, 118, 127]

        // GEt index of element
        arrayList2.add(127);
        arrayList2.add(127);
        System.out.println(arrayList2);// [11, 125, 66, 116, 118, 127, 127, 127]
        System.out.println(arrayList2.indexOf(127));// 5

        // Get element of index
        System.out.println(arrayList2.get(4));// 118

        // Get quantity element in array
        System.out.println(arrayList2.size());// 8

        // Check element in array list?
        System.out.println(arrayList2.contains(111));// false
        System.out.println(arrayList2.contains(127));// true

        // Clear all element
        arrayList2.clear();
        System.out.println(arrayList2);// []
    }

    public static void main(String[] args) {
        arrayToArrayListExample();
        arrayToArrayList1();
        arrayToArrayList2();
        toArray();
    }
}