package com.learn2.javabasic.s10;

import java.util.ArrayList;

public class ForExample {
    /***
     * Autoboxing là cơ chế tự động chuyển dổi kiểu dữ liệu nguyên thủy sang obj
     * của một Wrapper class tương ứng
     */
    public static void autoBoxing() {
        char ch = 'a';
        // Autoboxing - primitive to Character object conversion
        Character a = ch;

        // Print the values from obj
        System.out.println(a); // a

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // Autoboxing because ArrayList stores only obj
        arrayList.add(25);
        arrayList.add(45);
        // printing the values from object
        System.out.println(arrayList.get(1));// 45

    }

    /***
     * unboxing là cơ chế chuyển đổi các Wrapper của obj class sang kiểu dữ liệu
     * nguyên thủy tương ứng
     */
    public static void unboxing() {

        Character ch = 'b';
        // unboxing - Character obj to primitive conversion
        char a = ch;

        // Print the values from obj
        System.out.println(a); // b

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(20);
        // unboxing because ArrayList stores only obj
        int num = arrayList.get(0);

        // printing the values from object
        System.out.println(num);// 20

    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(55);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

    }
}
