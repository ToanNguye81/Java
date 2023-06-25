package com.learn.first.restapi.districts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.districts.model.CDistrict;

public interface IDistrictRepository extends JpaRepository<CDistrict, Integer> {
    // find district by Name
    // CDistrict findByName(String districtName);

}
