package com.learn3.javabasic.s10;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.text.DateFormatter;

public class Money {
    public static void main(String[] args) throws Exception {
        // B1. Đặt địa phương mặc định thành "vi-VN" (Việt Nam)
        Locale.setDefault(new Locale("vi", "VN"));
        // B2. Lấy địa phương hiện tại, trong trường hợp này là "vi-VN"
        Locale usLocale = Locale.getDefault();
        // Tạo một số thập phân
        double number = 102300.456f;
        // B3. Tạo một định dạng số với địa phương là "vi-VN"
        NumberFormat usNumberFormat = NumberFormat.getInstance(usLocale);
        // Sử dụng định dạng số để định dạng số và in ra kết quả
        System.out.println(usNumberFormat.format(number));

        // Currency
        // Tạo một đối tượng BigDecimal với giá trị 102,300.456
        BigDecimal number1 = new BigDecimal(102_300.456);
        // Tạo một định dạng số tiền tệ với địa phương là "vi-VN"
        NumberFormat usNumberFormat1 = NumberFormat.getCurrencyInstance(usLocale);
        // Sử dụng định dạng số tiền tệ để định dạng số và in ra kết quả
        System.out.println(usNumberFormat1.format(number1));

        // Date time
        // Tạo một đối tượng LocalDateTime đại diện
        LocalDateTime localDateTime = LocalDateTime.of(2023, 4, 30, 12, 22, 1, 500);
        // Định dạng ngày tháng theo mẫu "dd/MMMM/yyyy HH:mm:ss.SSS"
        String pattern = "dd/MMMM/yyyy HH:mm:ss.SSS";
        // Tạo định dạng ngày tháng theo mẫu trên
        DateTimeFormatter defauDateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        // Sử dụng định dạng ngày tháng để định dạng ngày tháng và in ra kết quả
        System.out.println(defauDateTimeFormatter.format(localDateTime));
    }
}
