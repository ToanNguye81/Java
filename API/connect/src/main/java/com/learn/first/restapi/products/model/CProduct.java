package com.learn.first.restapi.products.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.first.restapi.orders.model.COrder;

@Entity
@Table(name = "products")
public class CProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private long price;

    // Khai báo kiểu quan hệ n-n => order-product
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "products")
    private Set<COrder> orders;

    public CProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOrder(Set<COrder> orders) {
        this.orders = orders;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Set<COrder> getOrder() {
        return orders;
    }

}
