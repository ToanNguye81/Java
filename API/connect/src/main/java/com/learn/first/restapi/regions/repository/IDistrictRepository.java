package com.learn.first.restapi.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.first.restapi.regions.model.CDistrict;

public interface IDistrictRepository extends JpaRepository<CDistrict, Long> {
    // find district by id
    CDistrict findById(int id);

    // find district by Name
    CDistrict findByName(String districtName);

}
