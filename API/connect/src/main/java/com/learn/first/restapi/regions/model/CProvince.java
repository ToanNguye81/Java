package com.learn.first.restapi.regions.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "province")
public class CProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "districts")
    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    /* Có dòng này khi load province sẽ lấy tất cả thông tin quận huyện kèm theo */
    // @JsonManagedReference
    @JsonIgnore
    private Set<CDistrict> districts;

    public CProvince() {
    }

    public CProvince(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setProvinceName(String name) {
        this.name = name;
    }

    public void setProvinceCode(String code) {
        this.code = code;
    }

    public void setProvinceId(int id) {
        this.id = id;
    }

    public void setDistricts(Set<CDistrict> districts) {
        this.districts = districts;
    }

    public Set<CDistrict> getDistricts() {
        return districts;
    }

    public String getProvinceName() {
        return name;
    }

    public int getProvinceId() {
        return id;
    }

    public String getProvinceCode() {
        return code;
    }

}
