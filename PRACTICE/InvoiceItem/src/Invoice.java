public class Invoice {
    private int id;
    private Customer customer;
    private double amount;

    public Invoice(int id, Customer customer, double amount) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public double getCustomerDiscount() {
        return customer.getDiscount();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Invoice[id=" + id + ",amount=" + amount + "," + customer.toString() + "]";
    }
}
