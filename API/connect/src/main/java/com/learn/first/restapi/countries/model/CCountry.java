package com.learn.first.restapi.countries.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.first.restapi.regions.model.CRegion;

import java.util.Set;

@Entity
@Table(name = "countries")
public class CCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "ngay_tao")
    private long ngayTao;

    @Column(name = "ngay_cap_nhat")
    private long ngayCapNhat;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CRegion> regions;

    public CCountry() {
        super();
    }

    public CCountry(int id, String countryCode, String countryName, long ngayTao, long ngayCapNhat,
            Set<CRegion> regions) {
        super();
        this.id = id;
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
        this.regions = regions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setNgayTao(long ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgayCapNhat(long ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public int getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public long getNgayTao() {
        return ngayTao;
    }

    public long getNgayCapNhat() {
        return ngayCapNhat;
    }

    public String getCountryName() {
        return countryName;
    }

    public Set<CRegion> getRegions() {
        return regions;
    }

    public void setRegions(Set<CRegion> regions) {
        this.regions = regions;
    }

}
