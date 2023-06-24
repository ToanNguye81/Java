package com.learn.first.restapi.orders.model;

import javax.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.first.restapi.customers.model.CCustomer;
import com.learn.first.restapi.payments.model.CPayment;
import com.learn.first.restapi.products.model.CProduct;

@Entity
@Table(name = "orders")
public class COrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động sinh ra giá trị cho trường id
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "order_code", unique = true)
    private String orderCode;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "pizza_size")
    private String pizzaSize;

    @Column(name = "pizza_type")
    private String pizzaType;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "price")
    private Long price;

    @Column(name = "paid")
    private String paid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_by", nullable = false)
    @JsonBackReference
    private CCustomer customer;

    // Khai báo kiểu quan hệ n-n => orrder-product
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "orders_products", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
            @JoinColumn(name = "product_id") })
    private Set<CProduct> products;

    // mappedBy = "orders" sẽ bị báo lỗi
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    @JsonIgnore
    private CPayment payment;

    public COrder() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(CCustomer customer) {
        this.customer = customer;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void setPayment(CPayment payment) {
        this.payment = payment;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setProducts(Set<CProduct> products) {
        this.products = products;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getPaid() {
        return paid;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public Long getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public CPayment getPayment() {
        return payment;
    }

    public Set<CProduct> getProducts() {
        return products;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public CCustomer getCustomer() {
        return customer;
    }

}
