package com.learn.first.restapi.regions.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.first.restapi.countries.model.CCountry;

@Entity
@Table(name = "regions")
public class CRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "region_code")
    private String regionCode;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "ngay_tao")
    private long ngayTao;

    @Column(name = "ngay_cap_nhat")
    private long ngayCapNhat;

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonManagedReference
    private CCountry country;

    public CRegion() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CRegion(int id, String regionCode, String regionName, long ngayTao, long ngayCapNhat) {
        super();
        this.id = id;
        this.regionCode = regionCode;
        this.regionName = regionName;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(CCountry country) {
        this.country = country;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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

    public long getNgayTao() {
        return ngayTao;
    }

    public long getNgayCapNhat() {
        return ngayCapNhat;
    }

    public CCountry getCountry() {
        return country;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

}
