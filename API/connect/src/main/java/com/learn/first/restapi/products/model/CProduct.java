package com.learn.first.restapi.products.model;

import javax.persistence.*;

import com.learn.first.restapi.orders.model.COrder;

@Entity
@Table(name = "products")
public class CProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    @JoinColumn(name = "order_id")
    private COrder order;

    public CProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CProduct(long id, String name, String type, String color, long price, COrder order) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.price = price;
        this.order = order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOrder(COrder order) {
        this.order = order;
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

    public COrder getOrder() {
        return order;
    }

    public long getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
