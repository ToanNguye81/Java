package com.learn.j01_javabasic.s50;

public class Voucher {
    public String voucherCode = "CODE_1";

    public String getVoucherCode() {
        // returns the voucher code stored in the instance variable voucherCode
        return voucherCode;
    };

    public void setVoucherCode(String voucherCode) {
        // sets the value of the instance variable voucherCode to the given value.
        this.voucherCode = voucherCode;
    };

    public void showVoucher() {
        // prints the voucher code stored in the instance variable voucherCode to the
        // console
        System.out.println("Voucher Code is: " + this.voucherCode);
    }

    public void showVoucher(String voucherCode) {
        // takes a voucher code as an argument, and prints both the instance variable
        // voucherCode
        System.out.println("This voucher code : " + this.voucherCode);
        // and the voucher code passed as an argument to the console.
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
