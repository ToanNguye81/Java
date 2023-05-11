package com.learn4.javabasic.s10;

public abstract class CAnimal {

    public AnimalClass animClass;

    abstract public void animalSound();

    public void eat() {
        System.out.println("Animal eating...");
    }

    public void drink() {
        System.out.println("Animal Drink...");
    }
}
