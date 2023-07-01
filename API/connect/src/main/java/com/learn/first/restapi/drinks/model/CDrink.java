package com.learn.first.restapi.drinks.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

/*  Annotation @Entity được sử dụng để đánh dấu lớp này là
một "entity" trong ngữ cảnh của Java Persistence API (JPA) */
@Entity
@Table(name = "drinks") // Định nghĩa bảng mySQL
public class CDrink {

    /* Định nghĩa các cột tương ứng với các thuộc tính */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Nhập mã nước uống")
    @Size(min = 2, message = "Mã nước uống phải có ít nhất 2 ký tự ")
    @Column(name = "ma_nuoc_uong", unique = true)
    private String drinkCode;

    @NotNull(message = "Nhập tên nước uống")
    @Size(min = 2, message = "Tên nước uống phải có ít nhất 2 ký tự ")
    @Column(name = "ten_nuoc_uong", unique = true)
    private String drinkName;

    @NotNull(message = "Nhập giá trị nước uống")
    @Positive(message = "Giá trị nước uống phải lớn hơn 0")
    @Column(name = "gia_nuoc_uong")
    private long price;

    @Column(name = "note")
    private String note;

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

    public CDrink() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CDrink(String drinkCode, String drinkName, long price, Date dayCreated, Date dayUpdated) {
    }

    public long getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDrinkCode() {
        return drinkCode;
    }

    public Date getDayUpdated() {
        return dayUpdated;
    }

    public Date getDayCreated() {
        return dayCreated;
    }

    public long getPrice() {
        return price;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkCode(String drinkCode) {
        this.drinkCode = drinkCode;
    }

    public void setDayUpdated(Date dayUpdated) {
        this.dayUpdated = dayUpdated;
    }

    public void setDayCreated(Date dayCreated) {
        this.dayCreated = dayCreated;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

}
