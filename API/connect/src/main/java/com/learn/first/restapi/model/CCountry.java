
package com.learn.first.restapi.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Entity
@Table(name = "country")
public class CCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", unique = true)
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(targetEntity = CRegion.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Set<CRegion> regions;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Set<CRegion> getRegions() {
        return regions;
    }

    public void setRegions(Set<CRegion> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getCountryName();
    }
}
