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
    @Column(name = "id")
    private Long id;

    @Column(name = "ma_voucher")
    private String maVoucher;

    @Column(name = "phan_tram_giam_gia")
    private String phanTramGiamGia;

    @Column(name = "ghi_chu")
    private String ghiChu;

    public CVoucher() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public String getGhiChu() {
        return ghiChu;
    }

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

    public CVoucher(Long id, String maVoucher, String phanTramGiamGia, String ghiChu, Date ngayTao, Date ngayCapNhat) {
        this.maVoucher = maVoucher;
        this.phanTramGiamGia = phanTramGiamGia;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getGhiChu() + "\n" +
                "\n" + getMaVoucher() +
                "\n" + getNgayCapNhat() +
                "\n" + getNgayTao() +
                "\n" + getPhanTramGiamGia() +
                "\n" + "id: " + getId();
    }
    // public CVoucher(Long id, String maVoucher, String phanTramGiamGia, String
    // ghiChu, Long ngayTao, Long ngayCapNhat) {
    // super();
    // this.id = id;
    // this.maVoucher = maVoucher;
    // this.phanTramGiamGia = phanTramGiamGia;
    // this.ghiChu = ghiChu;
    // this.ngayTao = ngayTao;
    // this.ngayCapNhat = ngayCapNhat;
    // }

    // @Column(name = "ngay_tao")
    // private Long ngayTao;

    // @Column(name = "ngay_cap_nhat")
    // private Long ngayCapNhat;

    // public Long getNgayTao() {
    // return ngayTao;
    // }

    // public Long getNgayCapNhat() {
    // return ngayCapNhat;
    // }

    // public void setNgayTao(Long ngayTao) {
    // this.ngayTao = ngayTao;
    // }

    // public void setNgayCapNhat(Long ngayCapNhat) {
    // this.ngayCapNhat = ngayCapNhat;
    // }
}