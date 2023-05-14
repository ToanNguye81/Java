public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        InvoiceItem invoiceItem = new InvoiceItem(null, null, 0, 0);
        InvoiceItem invoiceItem2 = new InvoiceItem("4", "hẹn mai gặp", 3, 32);
        System.out.println(invoiceItem);
        System.out.println(invoiceItem2);
        invoiceItem2.setUnitPrice(9);
        System.out.println(invoiceItem2);
        System.out.println(invoiceItem2.getTotal());
    }

}
