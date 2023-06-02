package com.learn.first.restapi.regions.model;

import javax.persistence.*;

import com.learn.first.restapi.countries.model.CCountry;

@Entity
@Table(name = "regions")
public class CRegion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", unique = true)
    private int id;

    @Column(name = "region_code", unique = true)
    private String code;

    @Column(name = "region_name")
    private String name;

    @ManyToOne // mỗi CRegion thuộc về một CCountry duy nhất.
    @JoinColumn(name = "country_id") // quan hệ giữa CRegion và CCountry là một quan hệ quản lý bỏ trên 1 trong 2
    private CCountry country;// CRegion sẽ được liên kết với CCountry dựa trên khóa chính country

    public CRegion() {
        // TODO Auto-generated constructor stub
    }

    public CRegion(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegionCode(String code) {
        this.code = code;
    }

    public void setRegionName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getRegionCode() {
        return code;
    }

    public String getRegionName() {
        return name;
    }
}
