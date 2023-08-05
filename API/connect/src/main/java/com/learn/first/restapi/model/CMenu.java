package com.learn.first.restapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "menus")
public class CMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động sinh ra giá trị cho trường id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "size")
    @NotNull(message = "Hãy nhập kích cỡ piza")
    private String size;

    @Column(name = "diameter")
    @NotNull(message = "Hãy nhập đường kính pizza")
    @Positive(message = "Đường kính pizza lớn hơn 0")
    private Long diameter;

    @Column(name = "meat")
    @NotNull(message = "Hãy nhập số lượng thịt")
    @Range(min = 0, message = "Số lượng thịt lớn hơn hoặc bằng 0")
    private Long meat;

    @Column(name = "salad")
    @NotNull(message = "Hãy nhập gram salad")
    @Range(min = 0, message = "gram salad lớn hơn hoặc bằng 0")
    private Long salad;

    @Column(name = "drinkQuantity")
    @NotNull(message = "Hãy nhập số lượng nước")
    @Range(min = 0, message = "Số lượng nước lớn hơn hoặc bằng 0")
    private Long drinkQuantity;

    @Column(name = "price")
    @Positive(message = "Giá bán lớn hơn 0")
    @NotNull(message = "Hãy nhập price")
    private Long price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao", nullable = true, updatable = false)
    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dayCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_cap_nhat", nullable = true)
    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dayUpdated;

    public CMenu() {
        super();
    }

    public void setDayCreated(Date dayCreated) {
        this.dayCreated = dayCreated;
    }

    public void setDayUpdated(Date dayUpdated) {
        this.dayUpdated = dayUpdated;
    }

    public Long getDiameter() {
        return diameter;
    }

    public Long getDrinkQuantity() {
        return drinkQuantity;
    }

    public Long getId() {
        return id;
    }

    public Long getMeat() {
        return meat;
    }

    public Long getPrice() {
        return price;
    }

    public Long getSalad() {
        return salad;
    }

    public String getSize() {
        return size;
    }

    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }

    public void setDrinkQuantity(Long drinkQuantity) {
        this.drinkQuantity = drinkQuantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMeat(Long meat) {
        this.meat = meat;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setSalad(Long salad) {
        this.salad = salad;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getDayCreated() {
        return dayCreated;
    }

    public Date getDayUpdated() {
        return dayUpdated;
    }
}
