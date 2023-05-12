package com.learn4.javabasic.s10;

import java.util.ArrayList;

import com.learn4.javabasic.interfaceclass.Isumable;

public class CIntegerArrayList implements Isumable {

    // khai báo một thuộc tính kiểu ArrayList để lưu trữ danh sách các số nguyên
    private ArrayList<Integer> mIntegerArrayList;

    // constructor không tham số tạo một đối tượng CIntegerArrayList với danh sách
    // rỗng
    public CIntegerArrayList() {
        mIntegerArrayList = new ArrayList<>();
    }

    // constructor này tạo một đối tượng CIntegerArrayList với một danh sách được
    // chuyền vào
    public CIntegerArrayList(ArrayList<Integer> integerArrayList) {
        mIntegerArrayList = integerArrayList;
    }

    // getter cho thuộc tính mIntegerArrayList
    public ArrayList<Integer> getIntegerArrayList() {
        return mIntegerArrayList;
    }

    // setter cho thuộc tính mIntegerArrayList
    public void setIntegerArrayList(ArrayList<Integer> integerArrayList) {
        mIntegerArrayList = integerArrayList;
    }

    // phương thức tính tổng các phần tử trong danh sách mIntegerArrayList
    // và trả về một chuỗi miêu tả tổng
    public String getSum() {
        int sum = 0;
        for (Integer integer : mIntegerArrayList) {
            sum += integer;
        }
        return "Đây là Sum của class CIntegerArrayList: " + sum;
    }
}
