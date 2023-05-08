package com.learn.j50;

public class NewDevcampApp {
    public static void main(String[] args) {
        System.out.println("test class on package!");
        NewDevcampApp text = new NewDevcampApp();
        text.name1();
        System.out.println("Hello, World! My name is " + text.name2("ToanGL! ").length());
    }

    public void name1() {
        System.out.println("method name1");
    }

    public String name2(String param) {
        return param.trim();
    }

    public String name3(String string, int i) {
        return string.trim() + " " + i;
    }

    public String name4(String string, int i, String string2) {
        return string.trim() + " " + i + "" + " " + string2;
    }
}
