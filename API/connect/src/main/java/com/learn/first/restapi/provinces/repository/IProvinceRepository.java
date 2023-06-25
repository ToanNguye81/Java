package com.learn.first.restapi.provinces.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.provinces.model.CProvince;

public interface IProvinceRepository extends JpaRepository<CProvince, Integer> {

    Optional<CProvince> findByCode(String provinceCode);
}
