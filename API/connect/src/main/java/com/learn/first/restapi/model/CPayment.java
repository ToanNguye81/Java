package com.learn.first.restapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payments")
public class CPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "totalPrice")
    @NotNull(message = "Total Price không được để trống")
    @Positive(message = "Total Price phải lớn hơn 0")
    private Long totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "address")
    @Size(min = 2, message = "Address phải có ít nhất 2 ký tự ")
    private String address;

    // Khai báo kiểu quan hệ 1-1: order-payment
    // data sẽ chỉ được tải khi nó được truy cập hoặc yêu cầu.
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private COrder order;

    public CPayment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrder(COrder order) {
        this.order = order;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public COrder getOrder() {
        return order;
    }

}
