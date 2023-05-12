package com.learn4.javabasic.s10;

import com.learn4.javabasic.interfaceclass.Irunable;
import com.learn4.javabasic.interfaceclass.Other;

public class CCat extends CPet implements Irunable, Other {

    public CCat(int age, String name) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        System.out.println("Mèo chạy");
    }

    @Override
    public void running() {

    }

    @Override
    public void Other() {
        System.out.println("Cat Other");
    }

    @Override
    public int Other(int param) {
        return 5;
    }

    @Override
    public String Other(String param) {
        return "Meo meo";
    }

    @Override
    public String toString() {
        return "{name: Im cat}";
    }

}
