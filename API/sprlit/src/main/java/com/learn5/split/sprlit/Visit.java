package com.learn5.split.sprlit;

import java.util.Date;

public class Visit {
    private Tourist tourist;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Tourist tourist, Date date) {
        this.tourist = tourist;
        this.date = date;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public Date getDate() {
        return date;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public Double getServiceExpense() {
        return serviceExpense;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public void setServiceExpense(Double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public double getTotalExpense() {
        double totalExpense = this.productExpense + this.serviceExpense;
        return totalExpense;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
