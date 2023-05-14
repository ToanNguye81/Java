package com.learn4.javabasic.s10;

/*
 * Từ khóa "abstract" trước class CAnimal xác định rằng CAnimal là một abstract
 * class, nghĩa là không thể tạo ra một đối tượng CAnimal trực tiếp, mà chỉ có
 * thể tạo ra các đối tượng từ các lớp con của nó.
 */
public abstract class CAnimal {
    /*
     * public AnimalClass animClass là một thuộc tính (property) của CAnimal. Trong
     * trường hợp này, nó được khai báo public, có nghĩa là bất kỳ lớp nào có thể
     * truy cập trực tiếp đến thuộc tính này.
     */
    public AnimalClass animClass;

    /*
     * abstract public void animalSound() là một phương thức trừu tượng (abstract
     * method). Trong trường hợp này, nó được khai báo abstract và không có cài đặt
     * phương thức. Điều này có nghĩa là các lớp con của CAnimal phải triển khai
     * phương thức này.
     */
    abstract public void animalSound();

    /*
     * public void eat() và public void drink() là hai phương thức định nghĩa trong
     * CAnimal. Chúng không được khai báo là abstract, vì vậy chúng được triển khai
     * bên trong CAnimal và có thể được gọi trực tiếp từ các lớp con của nó.
     */
    public void eat() {
        System.out.println("Animal eating...");
    }

    public void drink() {
        System.out.println("Animal Drink...");
    }
}
