package com.learn.first.restapi.customers.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.first.restapi.orders.model.COrder;

@Entity
@Table(name = "customers")
public class CCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at", nullable = true, updatable = false)
    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at", nullable = true)
    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date updateAt;

    // Khai báo kiểu quan hệ 1-n => user-order
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<COrder> orders;

    public CCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreateAt(Date createAt) {
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

    public String getAddress() {
        return address;
    }

    public Date getCreateAt() {
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

    public String getPhone() {
        return phone;
    }

    public Set<COrder> getOrders() {
        return orders;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

}
