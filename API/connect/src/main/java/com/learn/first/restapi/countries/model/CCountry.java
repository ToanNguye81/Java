package com.learn.first.restapi.countries.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learn.first.restapi.regions.model.CRegion;

import java.util.Set;

@Entity
@Table(name = "countries")
public class CCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // tự động sinh ra giá trị cho trường country_id
    private int country_id;

    @Column(name = "country_code", unique = true)
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    /*
     * một đến nhiều => Mỗi CCountry có thể có nhiều CRegion liên quan.
     * mappedBy = "country" : CRegion là trường nắm giữ quan hệ với thực thể
     * CCountry. Điều này liên kết các CRegion với
     * CCountry tương ứng.
     * cascade = CascadeType.ALL chỉ định rằng tất cả các hoạt động CRUD trên
     * CCountry sẽ được áp dụng cho các thực thể CRegion
     * liên quan. Nghĩa là nếu bạn thực hiện một hoạt động CRUD trên một CCountry,
     * các thực thể CRegion liên quan cũng sẽ được tác động theo.
     */
    @Column(name = "regions")
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CRegion> regions;

    public CCountry() {
    }

    public CCountry(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public void setId(int country_id) {
        this.country_id = country_id;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getId() {
        return country_id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public Set<CRegion> getRegions() {
        return regions;
    }

    public void setRegions(Set<CRegion> regions) {
        this.regions = regions;
    }

}
