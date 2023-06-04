package com.learn.first.restapi.vouchers.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "vouchers")
public class CVoucher {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nhập mã giảm giá")
    @Size(min = 2, message = "Mã voucher phải có ít nhất 2 ký tự ")
    @Column(name = "ma_voucher", unique = true)
    private String maVoucher;

    @NotEmpty(message = "Nhập giá trị giảm giá")
    @Range(min = 1, max = 99, message = "Nhập giá trị từ 1 đến 99")
    @Column(name = "phan_tram_giam_gia")
    private Long phanTramGiamGia;

    @Column(name = "ghi_chu")
    private String ghiChu;

    public CVoucher() {
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public Long getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(Long phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Long getId() {
        return id;
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

    public CVoucher(String maVoucher, Long phanTramGiamGia, String ghiChu, Date ngayTao, Date ngayCapNhat) {
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
        return "id: " + getId() +
                "\n" + "ma voucher :" + getMaVoucher() +
                "\n" + "ngay cap nhat :" + getNgayCapNhat() +
                "\n" + "ngay tao :" + getNgayTao() +
                "\n" + "phan tram giam gia :" + getPhanTramGiamGia() +
                "\n" + "ghi chu :" + getGhiChu();
    }

}