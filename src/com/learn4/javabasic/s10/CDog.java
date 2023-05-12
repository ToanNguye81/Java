package com.learn4.javabasic.s10;

import com.learn4.javabasic.interfaceclass.IBarkable;
import com.learn4.javabasic.interfaceclass.Irunable;
import com.learn4.javabasic.interfaceclass.Other;

public class CDog extends CPet implements IBarkable, Irunable, Other {

    public CDog(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    @Override
    public void bark() {
        System.out.println("Chó sủa");
    }

    @Override
    public void barkBark() {

    }

    @Override
    public void run() {

    }

    @Override
    public void running() {

    }

    @Override
    public void Other() {

    }

    @Override
    public int Other(int param) {
        return 122;
    }

    @Override
    public String Other(String param) {
        return "0";
    }

    @Override
    public String toString() {
        return "{name: Im Dog}";
    }

}
