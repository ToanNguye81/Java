package com.learn.first.restapi.model;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "province")
public class CProvince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @NotNull(message = "Nhập province name")
    @Size(min = 2, message = "Name phải có ít nhất 2 ký tự ")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Nhập province code")
    @Size(min = 2, message = "Code phải có ít nhất 2 ký tự ")
    @Column(name = "code", unique = true)
    private String code;

    // @Column(name = "districts")
    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    /* Có dòng này khi load province sẽ lấy tất cả thông tin quận huyện kèm theo */
    // @JsonManagedReference
    @JsonIgnore
    private Set<CDistrict> districts;

    public CProvince() {
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
