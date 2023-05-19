package com.learn.first.restapi.customers.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ma_customer")
    private String maDrink;

    @Column(name = "phan_tram_giam_gia")
    private String phanTramGiamGia;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "ngay_tao")
    private long ngayTao;

    @Column(name = "ngay_cap_nhat")
    private long ngayCapNhat;

    public CCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CCustomer(long id, String maDrink, String phanTramGiamGia, String ghiChu, long ngayTao, long ngayCapNhat) {
        super();
        this.id = id;
        this.maDrink = maDrink;
        this.phanTramGiamGia = phanTramGiamGia;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMaDrink(String maDrink) {
        this.maDrink = maDrink;
    }

    public String getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(String phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setNgayTao(long ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgayCapNhat(long ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public long getId() {
        return id;
    }

    public String getMaDrink() {
        return maDrink;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public long getNgayTao() {
        return ngayTao;
    }

    public long getNgayCapNhat() {
        return ngayCapNhat;
    }

}
