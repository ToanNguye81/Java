package com.learn4.javabasic.s10;

import com.learn4.javabasic.interfaceclass.IFlyable;

public class CBird extends CPet implements IFlyable {

    @Override
    public void fly() {
        System.out.println("Bird flying");
    }

    public static void main(String[] args) {
        CBird myBird = new CBird(); // Cái khác của Cfish
        myBird.name = "My birds";
        myBird.animClass = AnimalClass.birds;
        myBird.eat();
        myBird.animalSound();
        myBird.print();
        myBird.play();
        myBird.fly();

        /*
         * Tìm hiểu tại sao phải gọi: ((CBird)
         * myBird).swim(); trong khi chỉ cần myBird.fly();
         */
    }
}
