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
        account1.credit(12222);
        System.out.println(account);
        System.out.println(account1);

        Account account2 = new Account("232", "Đại gia", 5000);// ver1
        account2.transferTo(45, account1);// ver1
        account2.debit(1276);// ver1
        System.out.println(account2);// ver1

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

        // Author and Book
        Author author = new Author("dsdnull", "sdfsd@fsma", 'f');
        Book book = new Book("chiến tranh", author, 76000, 44);
        System.out.println(book);

        // Quan hệ kế thừa
        // Circle
        Circle circle = new Circle(2, "red");
        System.out.println(circle);
        // Cylinder
        Circle cylinder = new Cylinder(4, 4, "green");
        System.out.println(cylinder);

        // Customer
        Customer customer = new Customer(22, "customer", 20);
        Invoice invoice = new Invoice(3, customer, 4.3);

        System.out.println(customer);
        System.out.println(invoice);

        // Person
        Person person = new Person("person-ti", "gia lai");
        Student student = new Student("Tokyo", "Japan", "dev back", "2019", 2000000);
        Staff staff = new Staff("Tuấn", "Phố hàng mái", "Phan Bội Châu", 23800);
        System.out.println(person);
        System.out.println(student);
        System.out.println(staff);

        // Acount ver 2

        AccountVer2 accountVer2 = new AccountVer2("s-ver", customer, 123500);
        accountVer2.deposit(12);
        accountVer2.withdraw(122);
        System.out.println(accountVer2);
    }

}
