package com.learn5.split.sprlit;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SplitStringAPI {

    @CrossOrigin
    @GetMapping("/rainbow")
    public ArrayList<Rainbow> rainbows() {
        String[] colorList = { "red", "orange", "blue", "indigo", "violet", "yellow", "green" };
        ArrayList<Rainbow> rainbowColorList = new ArrayList<>();

        for (String color : colorList) {
            Rainbow rainbowColor = new Rainbow(color);
            rainbowColorList.add(rainbowColor);
        }
        return rainbowColorList;
    }

    @GetMapping("/split")
    public ArrayList<Character> split() {
        String newString = "Nguyễn Trần Quốc Toàn";
        char[] charArray = newString.toCharArray();

        ArrayList<Character> arrayList = new ArrayList<>();
        for (char ch : charArray) {
            arrayList.add(ch);
        }
        return arrayList;
    }

    @GetMapping("/employee")
    public ArrayList<Employee> employee() {
        Employee employee1 = new Employee(1, "Thái", "Nguyễn", 120000);
        Employee employee2 = new Employee(2, "Tuấn", "Trần", 14000);
        Employee employee3 = new Employee(3, "Nam", "Lê", 1100000);

        employee1.raiseSalary(10);
        employee2.raiseSalary(20);

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);

        return employeeArrayList;
    }

}
