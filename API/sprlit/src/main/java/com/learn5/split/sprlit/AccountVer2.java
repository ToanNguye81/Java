package com.learn5.split.sprlit;

public class AccountVer2 {
    private String id;
    private Customer customer;
    private double balance = 0;

    public AccountVer2(String id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public AccountVer2(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // tiền gửi
    public double deposit(double amount) {
        this.balance += amount;
        return this.balance;
    }

    // tiền gửi
    public double withdraw(double amount) {
        if (this.balance > amount) {
            this.balance -= amount;
        } else {
            System.out.println("exceeds the current balance");
        }
        return this.balance;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Account[id=" + id + "," + customer + ",balance=" + balance + "]";
    }

}
