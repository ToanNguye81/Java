package com.learn.first.restapi.regions.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "province")
public class CProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDistricts(Set<CDistrict> districts) {
        this.districts = districts;
    }

    public Set<CDistrict> getDistricts() {
        return districts;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " " + getDistricts();
    }

}
