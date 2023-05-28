package com.learn.first.restapi.regions.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "district")
public class CDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "prefix")
    private String prefix;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "province_id")
    private CProvince province;

    @Column(name = "wards")
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    // @JsonManagedReference
    private Set<CWard> wards;

    public CDistrict() {
    }

    public CDistrict(int id, String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public void setDistrictName(String name) {
        this.name = name;
    }

    public void setDistrictId(int id) {
        this.id = id;
    }

    public void setDistrictPrefix(String prefix) {
        this.prefix = prefix;
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

    public String getDistrictName() {
        return name;
    }

    public String getDistrictPrefix() {
        return prefix;
    }

    public int getDistrictId() {
        return id;
    }

    // public Set<CWard> getWards() {
    // return wards;
    // }
}
