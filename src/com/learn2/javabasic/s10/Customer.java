package com.learn2.javabasic.s10;

public class Customer {

    int myNum;
    float myFloatNum;
    char myLetter;
    boolean myBool;
    String myName;

    public Customer() {
        myNum = 5;
        myFloatNum = 5.99f;
        myLetter = 'H'; // char ''
        myBool = true;
        myName = "ToanGL";
    }

    public Customer(int num, float floatNum, char letter, boolean bool, String name) {
        myNum = num;
        myFloatNum = floatNum;
        myLetter = letter; // char ''
        myBool = bool;
        myName = name;
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println(customer.myNum);
        System.out.println(customer.myFloatNum);
        System.out.println(customer.myLetter);
        System.out.println(customer.myBool);
        System.out.println(customer.myNum);

        customer = new Customer(1, 33.31f, 'T', false, "Fullstack Developer");
        System.out.println(customer.myNum);
        System.out.println(customer.myFloatNum);
        System.out.println(customer.myLetter);
        System.out.println(customer.myBool);
        System.out.println(customer.myName);
    }

}
