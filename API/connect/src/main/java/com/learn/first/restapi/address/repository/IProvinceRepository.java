package com.learn.first.restapi.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.address.model.CProvince;

public interface IProvinceRepository extends JpaRepository<CProvince, Integer> {
    CProvince findByCode(String provinceCode);
}
