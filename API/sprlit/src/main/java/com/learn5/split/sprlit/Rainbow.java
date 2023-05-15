package com.learn5.split.sprlit;

public class Rainbow {
    private String color;

    public Rainbow(String color) {
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Rainbow[color:" + color + "]";
    }
}
