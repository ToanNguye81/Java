public class App {
    public static void main(String[] args) throws Exception {

        // Employee
        Employee employee = new Employee(0, null, null, 0);
        System.out.println(employee);
        Employee employee1 = new Employee(1, "Toàn", "Nguyễn", 20000);
        System.out.println(employee1);

        // Invoice item
        InvoiceItem invoiceItem = new InvoiceItem(null, null, 0, 0);
        InvoiceItem invoiceItem2 = new InvoiceItem("4", "hẹn mai gặp", 3, 32);
        System.out.println(invoiceItem);
        System.out.println(invoiceItem2);
        invoiceItem2.setUnitPrice(9);
        System.out.println(invoiceItem2);
        System.out.println(invoiceItem2.getTotal());

        // Account
        Account account = new Account(null, null);
        Account account1 = new Account("232", "Đại gia");
        Account account2 = new Account("232", "Đại gia", 5000);

        account2.transferTo(45, account1);
        account1.credit(12222);
        account2.debit(1276);
        System.out.println(account);
        System.out.println(account1);
        System.out.println(account2);

        // Date
        Date nowDate = new Date(2, 13, 5645);
        System.out.println(nowDate);

        // Time
        Time time1 = new Time(10, 30, 59);
        Time time2 = new Time(21, 15, 59);

        System.out.println("Time 1: " + time1.toString());
        System.out.println("Time 2: " + time2.toString());

        time1.nextSecond();
        time2.previousSecond();

        System.out.println("Time 1 after nextSecond(): " + time1.toString());
        System.out.println("Time 2 after previousSecond(): " + time2.toString());
    }

}
