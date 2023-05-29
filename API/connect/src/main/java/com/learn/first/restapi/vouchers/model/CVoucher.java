package com.learn.first.restapi.vouchers.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "vouchers")
public class CVoucher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date id;

    @Column(name = "ma_voucher")
    private String maVoucher;

    @Column(name = "phan_tram_giam_gia")
    private String phanTramGiamGia;

    @Column(name = "ghi_chu")
    private String ghiChu;

    // @Column(name = "ngay_tao")
    // private Date ngayTao;

    // @Column(name = "ngay_cap_nhat")
    // private Date ngayCapNhat;

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

    public CVoucher() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CVoucher(Date id, String maVoucher, String phanTramGiamGia, String ghiChu, Date ngayTao, Date ngayCapNhat) {
        super();
        this.id = id;
        this.maVoucher = maVoucher;
        this.phanTramGiamGia = phanTramGiamGia;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public void setId(Date id) {
        this.id = id;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
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

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public Date getId() {
        return id;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

}
