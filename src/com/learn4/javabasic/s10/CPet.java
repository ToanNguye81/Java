package com.learn4.javabasic.s10;

public class CPet extends CAnimal {
    protected int age;
    protected String name;

    @Override
    public void animalSound() {
        // TODO Auto-generated method stub
        System.out.println("Pet sound...");
    }

    @Override
    public void eat() {
        System.out.println("Pet eating ....");
    }

    // @Override
    // public void drink() {
    // System.out.println("Drink eating ....");
    // }

    protected void print() {

    }

    protected void play() {

    }

    public static void main(String[] args) {
        CPet myPet = new CPet();
        myPet.name = "KIYA";
        myPet.age = 2;
        myPet.animClass = AnimalClass.mammals;
        myPet.animalSound();
        myPet.eat();
        myPet.drink();
        myPet.print();
        myPet.play();

    }

}
