package com.learn5.split.sprlit;

public class InvoiceItem {
    private String id;
    private String desc;
    private double unitPrice;
    private int qty;

    public InvoiceItem(String id, String desc, int qty, double unitPrice) {
        this.id = id;
        this.desc = desc;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public int getQty() {
        return qty;
    }

    public double getUnitPrice() {
        return Math.floor(unitPrice * 100) / 100;
    }

    public double getTotal() {
        return Math.floor(unitPrice * qty * 100) / 100;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "InvoiceItem [id=" + id + ",desc=" + desc + ",qty=" + qty + ",unitPrice=" + unitPrice + "]";
    }

}
