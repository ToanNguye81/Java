package com.learn.first.restapi.regions.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "provinces")
public class CProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "province_id", unique = true)
    private int province_id;

    @Column(name = "province_name", unique = true)
    private String provinceName;

    @Column(name = "province_code", unique = true)
    private String provinceCode;

    @Column(name = "districts")
    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CDistrict> districts;

    public CProvince() {
    }

    public CProvince(String provinceCode, String provinceName) {
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public void setProvinceId(int province_id) {
        this.province_id = province_id;
    }

    public void setDistricts(Set<CDistrict> districts) {
        this.districts = districts;
    }

    // public Set<CDistrict> getDistricts() {
    // return districts;
    // }

    public String getProvinceName() {
        return provinceName;
    }

    public int getProvinceId() {
        return province_id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }
}
