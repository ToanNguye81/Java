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

    @GetMapping("/circle-area")
    public ArrayList<Circle> circle() {
        // Circle
        Circle circle1 = new Circle(2, "red");
        Circle circle2 = new Circle(2, "green");
        Circle circle3 = new Circle(2, "blue");
        ArrayList<Circle> circleArrayList = new ArrayList<>();

        circleArrayList.add(circle1);
        circleArrayList.add(circle2);
        circleArrayList.add(circle3);
        return circleArrayList;

    }

    @GetMapping("/invoice-item")
    public ArrayList<InvoiceItem> invoice() {
        // InvoiceItem
        InvoiceItem invoiceItem1 = new InvoiceItem("1", "success", 10, 700.43);
        InvoiceItem invoiceItem2 = new InvoiceItem("2", "waiting", 10, 800.2);
        InvoiceItem invoiceItem3 = new InvoiceItem("5", "delivery", 10, 900.43);
        ArrayList<InvoiceItem> invoiceItemArrayList = new ArrayList<>();

        invoiceItemArrayList.add(invoiceItem1);
        invoiceItemArrayList.add(invoiceItem2);
        invoiceItemArrayList.add(invoiceItem3);
        return invoiceItemArrayList;

    }

    @GetMapping("/account")
    public ArrayList<Account> account() {
        // Account
        Account account1 = new Account("1", "Hải", 12000);
        Account account2 = new Account("2", "Tuấn", 14000);
        Account account3 = new Account("4", "Triều", 15000);
        ArrayList<Account> accountArrayList = new ArrayList<>();

        accountArrayList.add(account1);
        accountArrayList.add(account2);
        accountArrayList.add(account3);
        return accountArrayList;
    }

    @GetMapping("/length")
    public int length() {
        String newString = "Nguyễn Trần Quốc Toàn";
        int length = newString.length();
        return length;
    }

    @GetMapping("/checknumber")
    public ArrayList checknumber() {
        int number1 = 1;
        int number2 = 2;
        String result1 = new OddEvenChecker(number1).isEven();
        String result2 = new OddEvenChecker(number2).isEven();

        ArrayList<String> resultList = new ArrayList<>();
        resultList.add(result1);
        resultList.add(result2);

        return resultList;

    }

}
