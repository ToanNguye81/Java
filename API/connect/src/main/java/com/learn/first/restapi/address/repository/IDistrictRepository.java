package com.learn.first.restapi.address.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.address.model.CDistrict;

public interface IDistrictRepository extends JpaRepository<CDistrict, Long> {
    // find district by Name
    CDistrict findByName(String districtName);

    Optional<CDistrict> findById(int districtId);

}
