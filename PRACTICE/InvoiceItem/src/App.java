public class App {
    public static void main(String[] args) throws Exception {
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

    }

}
