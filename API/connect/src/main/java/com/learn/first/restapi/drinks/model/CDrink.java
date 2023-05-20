package com.learn.first.restapi.drinks.model;

import javax.persistence.*;

/*  Annotation @Entity được sử dụng để đánh dấu lớp này là
một "entity" trong ngữ cảnh của Java Persistence API (JPA) */
@Entity
@Table(name = "drinks") // Định nghĩa bảng mySQL
public class CDrink {

    /* Định nghĩa các cột tương ứng với các thuộc tính */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ma_nuoc_uong")
    private String maNuocUong;

    @Column(name = "ten_nuoc_uong")
    private String tenNuocUong;

    @Column(name = "gia_nuoc_uong")
    private long price;

    @Column(name = "ngay_tao")
    private long ngayTao;

    @Column(name = "ngay_cap_nhat")
    private long ngayCapNhat;

    public CDrink() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CDrink(long id, String maNuocUong, String tenNuocUong, long price, long ngayTao, long ngayCapNhat) {
        super();
        this.id = id;
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

    public long getNgayCapNhat() {
        return ngayCapNhat;
    }

    public long getNgayTao() {
        return ngayTao;
    }

    public long getPrice() {
        return price;
    }

    public String getTenNuocUong() {
        return tenNuocUong;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMaNuocUong(String maNuocUong) {
        this.maNuocUong = maNuocUong;
    }

    public void setNgayCapNhat(long ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public void setNgayTao(long ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setTenNuocUong(String tenNuocUong) {
        this.tenNuocUong = tenNuocUong;
    }

}
