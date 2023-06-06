package com.learn.first.restapi.address.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.address.model.CProvince;

public interface IProvinceRepository extends JpaRepository<CProvince, Integer> {

    Optional<CProvince> findByCode(String provinceCode);
}
