package com.learn3.javabasic.s10;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Order2 {
    int id; // id của order
    String customerName; // tên khách hàng
    Integer price;// tổng giá tiền
    Date orderDate; // ngày thực hiện order
    Boolean confirm; // đã xác nhận hay chưa?
    String[] items; // danh sách mặt hàng đã mua
    Person buyer;// người mua, là một object thuộc class Person

    public Order2(int id, String customerName, Integer price, Date orderDate, Boolean confirm, String[] items,
            Person buyer) {
        this.id = id;
        this.customerName = customerName;
        this.price = price;
        this.orderDate = orderDate;
        this.confirm = confirm;
        this.items = items;
        this.buyer = buyer;
    }

    public Order2(int id, String customerName, Integer price, Date orderDate, Boolean confirm, String[] items) {
        this.id = id;
        this.customerName = customerName;
        this.price = price;
        this.orderDate = orderDate;
        this.confirm = confirm;
        this.items = items;
    }

    public Order2(int id, String customerName, Integer price, Date orderDate, Boolean confirm, Person buyer) {
        this.id = id;
        this.customerName = customerName;
        this.price = price;
        this.orderDate = orderDate;
        this.confirm = confirm;
        this.buyer = buyer;
        this.items = new String[] { "Audi", "novo" };
    }

    public Order2(int id, String customerName, Integer price, Date orderDate, Boolean confirm) {
        this.id = id;
        this.customerName = customerName;
        this.price = price;
        this.orderDate = orderDate;
        this.confirm = confirm;

    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày tháng
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); // Định dạng tiền tệ

        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(this.id).append("\n");
        sb.append("Khách hàng: ").append(this.customerName).append("\n");
        sb.append("Tổng giá tiền: ").append(currencyFormat.format(this.price)).append("\n");
        sb.append("Ngày thực hiện order: ").append(dateFormat.format(this.orderDate)).append("\n");
        sb.append("Đã xác nhận: ").append(this.confirm ? "Có" : "Không").append("\n");
        sb.append("Danh sách mặt hàng đã mua:\n");
        for (String item : this.items) {
            sb.append("- ").append(item).append("\n");
        }
        if (this.buyer != null) {
            sb.append("Người mua: ").append(this.buyer).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // khởi tạo 4 đối tượng với 4 loại constructor khác nhau
        Order2 order1 = new Order2(1, "John Doe", 100, new Date(), true, new String[] { "item1", "item2" },
                new Person("Jane Doe"));
        Order2 order2 = new Order2(2, "Jane Doe", 200, new Date(), false, new String[] { "item3", "item4" });
        Order2 order3 = new Order2(3, "Mike Smith", 300, new Date(), true, new Person("John Smith"));
        Order2 order4 = new Order2(4, "Tom Brown", 400, new Date(), false);

        // Tạo một ArrayList và thêm 4 đối tượng vào đó
        ArrayList<Order2> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);

        // In thông tin của các đối tượng trong orderList
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày tháng
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")); // Định dạng tiền tệ
        for (Order2 order : orderList) {
            System.out.println("ID: " + order.id);
            System.out.println("Khách hàng: " + order.customerName);
            System.out.println("Tổng giá tiền: " + currencyFormat.format(order.price));
            System.out.println("Ngày thực hiện order: " +
                    dateFormat.format(order.orderDate));
            System.out.println("Đã xác nhận: " + (order.confirm ? "Có" : "Không"));
            System.out.println("Danh sách mặt hàng đã mua:");
            for (String item : order.items) {
                System.out.println("- " + item);
            }
            if (order.buyer != null) {
                System.out.println("Người mua: " + order.buyer);
            }
            System.out.println("---------------------------");
        }

    }
}
