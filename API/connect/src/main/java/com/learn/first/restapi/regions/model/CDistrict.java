package com.learn.first.restapi.regions.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "districts")
public class CDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "district_id", unique = true)
    private int district_id;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "district_prefix", unique = true)
    private String districtPrefix;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private CProvince province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CWard> wards;

    public CDistrict() {
    }

    public CDistrict(int district_id, String districtName, String districtPrefix) {
        this.districtName = districtName;
        this.districtPrefix = districtPrefix;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setDistrictId(int district_id) {
        this.district_id = district_id;
    }

    public void setDistrictPrefix(String districtPrefix) {
        this.districtPrefix = districtPrefix;
    }

    public void setProvince(CProvince province) {
        this.province = province;
    }

    public void setWards(Set<CWard> wards) {
        this.wards = wards;
    }

    public void setWard(Set<CWard> wards) {
        this.wards = wards;
    }

    public Set<CWard> getWards() {
        return wards;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getDistrictPrefix() {
        return districtPrefix;
    }

    public CProvince getProvince() {
        return province;
    }

    public int getDistrictId() {
        return district_id;
    }

    public Set<CWard> getWard() {
        return wards;
    }
}
