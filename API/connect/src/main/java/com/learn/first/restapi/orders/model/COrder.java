package com.learn.first.restapi.orders.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.first.restapi.customers.model.CCustomer;
import com.learn.first.restapi.products.model.CProduct;

import java.util.Set;

@Entity
@Table(name = "orders")
public class COrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // tự động sinh ra giá trị cho trường id
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

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private CCustomer customer;

    @Column(name = "products")
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CProduct> products;

    public COrder() {
    }

    public COrder(String orderCode, String orderName, String pizzaSize, String pizzaType, String voucherCode,
            Long price, String paid, Set<CProduct> products) {
        this.orderCode = orderCode;
        this.pizzaSize = pizzaSize;
        this.pizzaType = pizzaType;
        this.voucherCode = voucherCode;
        this.price = price;
        this.paid = paid;
        this.products = products;
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
