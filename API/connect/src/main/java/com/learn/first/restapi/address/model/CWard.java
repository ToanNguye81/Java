package com.learn.first.restapi.address.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "wards")
public class CWard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDistrict(CDistrict district) {
        this.district = district;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public CDistrict getDistrict() {
        return district;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "{" + getId() + "," + getPrefix().toString() + "," + getName().toString() + "}";
    }

}
