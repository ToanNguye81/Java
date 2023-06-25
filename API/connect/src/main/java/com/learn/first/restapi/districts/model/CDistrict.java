package com.learn.first.restapi.districts.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learn.first.restapi.provinces.model.CProvince;
import com.learn.first.restapi.wards.model.CWard;

@Entity
@Table(name = "district")
public class CDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @NotNull(message = "Nhập district name")
    @Size(min = 2, message = "Name phải có ít nhất 2 ký tự ")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Nhập district prefix")
    @Size(min = 2, message = "Prefix phải có ít nhất 2 ký tự ")
    @Column(name = "prefix")
    private String prefix;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "province_id")
    private CProvince province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<CWard> wards;

    public CDistrict() {
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
