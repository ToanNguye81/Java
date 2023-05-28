package com.learn.first.restapi.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.regions.model.CProvince;

public interface IProvinceRepository extends JpaRepository<CProvince, Long> {
    CProvince findByCode(String province);

}
