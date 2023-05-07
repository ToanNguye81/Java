package com.learn.j50_javabasic.s10;

public class NewDevcampApp {
    
    // create new method in class NewDevcampApp
    /* Phương thức tĩnh (static method) trong Java là phương thức được gán cho lớp
    chứ không phải đối tượng của lớp đó. Nó có thể được gọi trực tiếp từ tên lớp mà
    không cần tạo một đối tượng của lớp đó. */
    public static void name(String name, int age) {
        System.out.println("My name is  "+name + " age is " +age);
    }

    /*  (non-static method) 
    là phương thức được gán cho các đối tượng của lớp. 
    Để gọi một phương thức không tĩnh, cần phải tạo một đối tượng của lớp đó 
    và gọi phương thức thông qua đối tượng đó. */
    public void name (String name) {
        System.out.println("My name is  "+name);
    }

    // keyboard shortcut psvm = public static void main"
    public static void main(String[] args) {
        System.out.println("I'm java dev newbie ");
        NewDevcampApp.name("Toàn", 19);
        
        // NewDevcampApp.name("Tý"); non-static method => Error
        NewDevcampApp newApp= new NewDevcampApp();
        newApp.name("Ty");
    }
}
