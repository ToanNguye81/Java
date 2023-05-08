package com.learn2.javabasic.s10;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayToArrayList {
    public static void arrayToArrayListExample() {
        String[] strings = new String[] { "a", "23", "ff", "d", "d" };
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strings));
        System.out.println(arrayList);
    }

    public static void main(String[] args) {
        arrayToArrayListExample();
    }
}