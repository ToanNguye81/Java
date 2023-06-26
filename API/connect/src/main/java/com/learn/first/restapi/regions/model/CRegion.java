package com.learn.first.restapi.regions.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.first.restapi.countries.model.CCountry;

@Entity
@Table(name = "region")
public class CRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", unique = true)
    private Integer id;

    @Column(name = "region_code", unique = true)
    private String regionCode;

    @Column(name = "region_name")
    private String regionName;

    @ManyToOne // mỗi CRegion thuộc về một CCountry duy nhất.
    @JoinColumn(name = "country_id") // quan hệ giữa CRegion và CCountry là một quan hệ quản lý bỏ trên 1 trong 2
    @JsonIgnore
    private CCountry country;// CRegion sẽ được liên kết với CCountry dựa trên khóa chính country

    public CRegion() {
        // TODO Auto-generated constructor stub
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setCountry(CCountry country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public CCountry getCountry() {
        return country;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getRegionName();
    }
}
