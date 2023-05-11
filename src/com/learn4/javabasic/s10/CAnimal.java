package com.learn4.javabasic.s10;

public abstract class CAnimal {
    /*
     * Trong lập trình hướng đối tượng, một abstract class (lớp trừu tượng) là một
     * lớp mà không thể được khởi tạo thành đối tượng, nhưng được sử dụng để định
     * nghĩa các phương thức và thuộc tính cơ bản mà các lớp con có thể kế thừa và
     * triển khai. Abstract class được sử dụng để xác định một bộ các phương thức và
     * thuộc tính chung cho các lớp con và đảm bảo rằng chúng triển khai các phương
     * thức đó một cách đồng nhất.
     */

    public AnimalClass animClass;

    abstract public void animalSound();

    public void eat() {
        System.out.println("Animal eating...");
    }

    public void drink() {
        System.out.println("Animal Drink...");
    }
}
