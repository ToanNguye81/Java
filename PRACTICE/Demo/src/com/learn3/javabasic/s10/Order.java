package com.learn3.javabasic.s10;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Order {
    int id; // id của order
    String customerName; // tên khách hàng
    long price;// tổng giá tiền
    Date orderDate; // ngày thực hiện order
    boolean confirm; // đã xác nhận hay chưa?
    String[] items; // danh sách mặt hàng đã mua

    // Order with name of customer
    public Order(String paramCustomerName) {
        this.id = 1;
        this.customerName = paramCustomerName;
        this.price = 12000000;
        this.orderDate = new Date();
        this.confirm = true;
        this.items = new String[] { "Pizza", "drink" };
    }

    // Order with all parameter
    public Order(int paramId, String paramCustomerName, long paramPrice, Date paramOrderDate, boolean paramConfirm,
            String[] paramItems) {
        this.id = paramId;
        this.customerName = paramCustomerName;
        this.price = paramPrice;
        this.orderDate = paramOrderDate;
        this.confirm = paramConfirm;
        this.items = paramItems;
    }

    // Order with all parameter
    public Order(int paramId, String paramCustomerName, long paramPrice) {
        this(paramId, paramCustomerName, paramPrice, new Date(), true, new String[] { "bún", "chả", "cá" });
    }

    // Order none parameter
    public Order() {
        this("sdsd");
    }

    @Override
    public String toString() {
        // B1. Đặt địa phương mặc định thành "vi-VN" (Việt Nam)
        Locale.setDefault(new Locale("vi", "VN"));
        // B2. Lấy địa phương hiện tại, trong trường hợp này là "vi-VN"
        String pattern = "dd-MMMM-yyyy HH:mm:ss.SSS";
        DateTimeFormatter defaultTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        // B3. Tạo một định dạng số với địa phương là "vi-VN"
        Locale usLocale = Locale.getDefault();
        NumberFormat usPriceFormat = NumberFormat.getCurrencyInstance(usLocale);

        // Return String
        return "Order=[id=" + id + "," +
                "customerName=" + customerName + "," +
                "price=" + usPriceFormat.format(price) + "," +
                "orderDate="
                + defaultTimeFormatter.format(orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                + "," +
                "confirm=" + confirm + "," +
                "items=" + Arrays.toString(items) +
                "]";
    }

    public static void main(String[] args) {

        Order order1 = new Order();
        Order order2 = new Order(44, "dsds", 456677, new Date(), true, new String[] { "cat", "toyota" });
        Order order3 = new Order(47, "Hihi", 89000000);
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
    }
}
