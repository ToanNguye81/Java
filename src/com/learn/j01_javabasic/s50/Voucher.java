package com.learn.j01_javabasic.s50;

public class Voucher {
    public String voucherCode = "CODE_1";

    public String getVoucherCode() {
        return voucherCode;
    };

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    };

    public void showVoucher() {
        System.out.println("Voucher Code is: " + this.voucherCode);
    }

    public void showVoucher(String voucherCode) {
        System.out.println("This voucher code : " + this.voucherCode);
        System.out.println("This voucher code too : " + voucherCode);
    };

    public static void main(String[] args) throws Exception {
        Voucher voucher = new Voucher();
        // 1. Run class then comment
        voucher.showVoucher(); // Voucher Code is: V99999999

        // 2. Run again
        voucher.voucherCode = "CODE_2";// This voucher code : CODE1
        voucher.showVoucher("CODE_123");// This voucher code too : CODE_123

        // 3. Run again
        String code = "CODE_444";
        voucher.setVoucherCode(code);
        System.out.println(voucher.getVoucherCode()); // CODE_444
        voucher.showVoucher(voucher.getVoucherCode());
        // This voucher code : CODE_444
        // This voucher code too : CODE_444
        voucher.showVoucher(); // Voucher Code is: CODE_444
        ;
    }
}
