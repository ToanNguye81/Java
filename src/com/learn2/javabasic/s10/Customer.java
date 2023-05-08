package com.learn2.javabasic.s10;

public class Customer {

    int myNum;
    float myFloatNum;
    char myLetter;
    boolean MyBool;
    String myName;

    public Customer() {
        myNum = 5;
        myFloatNum = 5.99f;
        myLetter = 'H'; // char ''
        MyBool = true;
        myName = "ToanGL";
    }

    public Customer(int num, float floatNum, char letter, boolean bool, String name) {
        myNum = num;
        myFloatNum = floatNum;
        myLetter = letter; // char ''
        MyBool = bool;
        myName = name;
    }

}
