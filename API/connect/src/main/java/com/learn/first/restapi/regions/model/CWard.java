package com.learn.first.restapi.regions.model;

import javax.persistence.*;

@Entity
@Table(name = "wards")
public class CWard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ward_id", unique = true)
    private int ward_id;

    @Column(name = "ward_name")
    private String wardName;

    @Column(name = "ward_prefix")
    private String wardPrefix;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private CDistrict district;

    public CWard() {
    }

    public CWard(String wardName, String wardPrefix) {
        this.wardName = wardName;
        this.wardPrefix = wardPrefix;
    }

    // public CDistrict getDistrict() {
    // return district;
    // }

    public String getWardName() {
        return wardName;
    }

    public String getWardPrefix() {
        return wardPrefix;
    }

    public int getWardId() {
        return ward_id;
    }

    public void setWardId(int ward_id) {
        this.ward_id = ward_id;
    }

    public void setDistrict(CDistrict district) {
        this.district = district;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public void setWardPrefix(String wardPrefix) {
        this.wardPrefix = wardPrefix;
    }

}
