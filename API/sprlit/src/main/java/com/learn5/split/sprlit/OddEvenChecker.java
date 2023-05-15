package com.learn5.split.sprlit;

public class OddEvenChecker {

    int number;

    public OddEvenChecker(int number) {
        this.number = number;
    }

    public String isEven() {
        if (this.number % 2 == 0) {
            return this.number + " is even.";
        } else {
            return this.number + " is odd.";
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
