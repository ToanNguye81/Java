package com.learn.first.restapi.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.address.model.CDistrict;

public interface IDistrictRepository extends JpaRepository<CDistrict, Integer> {
    // find district by Name
    CDistrict findByName(String districtName);

}
