package com.learn.first.restapi.drinks.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Nhập mã giảm giá")
    @Size(min = 2, message = "Mã nước uống phải có ít nhất 2 ký tự ")
    @Column(name = "ma_nuoc_uong", unique = true)
    private String maNuocUong;

    @NotEmpty(message = "Nhập giá trị giảm giá")
    @Size(min = 2, message = "Tên nước uống phải có ít nhất 2 ký tự ")
    @Column(name = "ten_nuoc_uong", unique = true)
    private String tenNuocUong;

    @Column(name = "gia_nuoc_uong")
    private long price;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao", nullable = true, updatable = false)
    @CreatedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date ngayTao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_cap_nhat", nullable = true)
    @LastModifiedDate
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date ngayCapNhat;

    public CDrink() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CDrink(String maNuocUong, String tenNuocUong, long price, Date ngayTao, Date ngayCapNhat) {
        this.maNuocUong = maNuocUong;
        this.tenNuocUong = tenNuocUong;
        this.price = price;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public long getId() {
        return id;
    }

    public String getMaNuocUong() {
        return maNuocUong;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public long getPrice() {
        return price;
    }

    public String getTenNuocUong() {
        return tenNuocUong;
    }

    public void setMaNuocUong(String maNuocUong) {
        this.maNuocUong = maNuocUong;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setTenNuocUong(String tenNuocUong) {
        this.tenNuocUong = tenNuocUong;
    }

}
