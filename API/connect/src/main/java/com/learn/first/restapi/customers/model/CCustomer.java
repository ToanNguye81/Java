package com.learn.first.restapi.customers.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "ho_va_ten")
    private String hoTen;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ngay_tao")
    private long ngayTao;

    @Column(name = "ngay_cap_nhat")
    private long ngayCapNhat;

    public CCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CCustomer(long id, String hoTen, String email, String soDienThoai, String diaChi, long ngayTao,
            long ngayCapNhat) {
        super();
        this.id = id;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getPhanTramGiamGia() {
        return email;
    }

    public void setNgayTao(long ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.hoTen = hoTen;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setNgayCapNhat(long ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public long getId() {
        return id;
    }

    public long getNgayTao() {
        return ngayTao;
    }

    public long getNgayCapNhat() {
        return ngayCapNhat;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }
}
