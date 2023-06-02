package com.learn.first.restapi.countries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.countries.model.CRegion;

public interface IRegionRepository extends JpaRepository<CRegion, Long> {

}
