package com.learn.first.restapi.regions.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ward")
public class CWard {

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
    @JoinColumn(name = "district_id")
    private CDistrict district;

    public CWard() {
    }

    public CWard(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public String getWardName() {
        return name;
    }

    public String getWardPrefix() {
        return prefix;
    }

    public int getWardId() {
        return id;
    }

    public void setWardId(int id) {
        this.id = id;
    }

    public void setDistrict(CDistrict district) {
        this.district = district;
    }

    public void setWardName(String name) {
        this.name = name;
    }

    public void setWardPrefix(String prefix) {
        this.prefix = prefix;
    }

}
