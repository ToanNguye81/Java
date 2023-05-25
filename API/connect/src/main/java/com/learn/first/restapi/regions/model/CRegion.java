package com.learn.first.restapi.regions.model;

import javax.persistence.*;

import com.learn.first.restapi.countries.model.CCountry;

@Entity
@Table(name = "regions")
public class CRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "region_id", unique = true)
    private int region_id;

    @Column(name = "region_code", unique = true)
    private String regionCode;

    @Column(name = "region_name")
    private String regionName;

    @ManyToOne // mỗi CRegion thuộc về một CCountry duy nhất.
    @JoinColumn(name = "country_id")
    // quan hệ giữa CRegion và CCountry là một quan hệ quản lý bỏ trên 1 trong 2
    private CCountry country;// CRegion sẽ được liên kết với CCountry dựa trên khóa chính country

    public CRegion() {
        // TODO Auto-generated constructor stub
    }

    public CRegion(String regionCode, String regionName) {
        this.regionCode = regionCode;
        this.regionName = regionName;
    }

    public void setId(int region_id) {
        this.region_id = region_id;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public long getId() {
        return region_id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

}
