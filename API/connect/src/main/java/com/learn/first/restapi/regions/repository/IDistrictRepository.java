package com.learn.first.restapi.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.first.restapi.regions.model.CDistrict;

public interface IDistrictRepository extends JpaRepository<CDistrict, Long> {
    CDistrict findByName(String districtName);
}
