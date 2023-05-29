package com.learn.first.restapi.customers.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.first.restapi.orders.model.COrder;

@Entity
@Table(name = "customers")
public class CCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "create_at")
    private long createAt;

    @Column(name = "update_at")
    private long updateAt;

    @Column(name = "orders")
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<COrder> orders;

    public CCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CCustomer(long id, String fullName, String email, String phone, String address, long createAt,
            long updateAt, Set<COrder> orders) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.orders = orders;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setOrders(Set<COrder> orders) {
        this.orders = orders;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getAddress() {
        return address;
    }

    public long getCreateAt() {
        return createAt;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public long getId() {
        return id;
    }

    public Set<COrder> getOrders() {
        return orders;
    }

    public String getPhone() {
        return phone;
    }

    public long getUpdateAt() {
        return updateAt;
    }
}
