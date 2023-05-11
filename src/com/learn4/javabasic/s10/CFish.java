package com.learn4.javabasic.s10;

import com.learn4.javabasic.interfaceclass.Iswimable;

public class CFish extends CPet implements Iswimable {
    @Override
    public void swim() {
        System.out.println("The fish swimming");
    }

    public static void main(String[] args) {
        CPet myFish = new CFish();
        myFish.name = "sdafds";
        myFish.animClass = AnimalClass.fish;
        myFish.eat();
        myFish.animalSound();
        myFish.print();
        myFish.play();
        ((CFish) myFish).swim();//
        /*
         * Chụp kết quả và tìm hiểu tại sao phải gọi: ((CFish)
         * myFish).swim(); trong khi chỉ cần myBird.fly();
         */
    }
}
