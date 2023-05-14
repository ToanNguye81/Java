package com.learn.js50_javabasic.s20;

import com.learn.j01_javabasic.s50.Voucher;

public class MainVoucher {
    public static void main(String[] args) {
        Voucher voucher1 = new Voucher();
        Voucher voucher2 = new Voucher();

        if (voucher1 == voucher2) {
            System.out.println("1. We are the same");
        } else {
            System.out.println("2. We are NOT the same");
        }
        // 2. We are NOT the same

        voucher1 = voucher2;
        if (voucher1 == voucher2) {
            System.out.println("3. We are the same");
        } else {
            System.out.println("4. We are NOT the same");
        }
        // 3. We are the same

        voucher1.setVoucherCode("AMAZING");
        if (voucher1 == voucher2) {
            System.out.println("5. We are the same");
        } else {
            System.out.println("6. We are NOT the same");
        }
    }
}
