package com.learn.first.restapi.address.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "district")
public class CDistrict {

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
    @JoinColumn(name = "province_id")
    private CProvince province;

    @Column(name = "wards")
    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    // @JsonManagedReference
    @JsonIgnore
    private Set<CWard> wards;

    public CDistrict() {
    }

    public CDistrict(int id, String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrefix(String prefix) {
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

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getId() {
        return id;
    }

    public Set<CWard> getWards() {
        return wards;
    }

    public CProvince getProvince() {
        return province;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getWards().toString();
    }
}
