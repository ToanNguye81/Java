package com.learn5.split.sprlit;

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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public int getCustomerId() {
        return customer.getId();
    }

    public double getCustomerDiscount() {
        return customer.getDiscount();
    }

    public double getAmountAfterDiscountr(double discount) {
        this.amount = amount * (100 - discount) / 100;
        return this.amount;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Invoice[id=" + id + ",amount=" + amount + "," + customer + "]";
    }
}
