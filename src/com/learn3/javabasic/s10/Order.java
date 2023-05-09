package com.learn3.javabasic.s10;

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
        this.price = 45678;
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
        this.id = paramId;
        this.customerName = paramCustomerName;
        this.price = paramPrice;
    }

    // Order none parameter
    public Order() {
        this("sdsd");
    }

    @Override
    public String toString() {
        return "Order= [id=" + id +
                "customerName=" + customerName + "," +
                // "price=" + price.format(pri) + "," +
                // "orderDate=" + orderDate.getVietNamDate() + "," +
                "confirm=" + confirm + "," +
                "items" + Arrays.toString(items) +
                "]";
    }

    public String getVietNamDate(Date paramDate) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("EEEE,dd-MMMM-yyyy")
                .localizedBy(Locale.forLanguageTag("vi"));
        LocalDate today = LocalDate.now(ZoneId.systemDefault());
        return String.format(myFormatObj.format(today));
    }

}
