package com.learn.first.restapi.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.regions.model.CRegion;

public interface IRegionRepository extends JpaRepository<CRegion, Long> {

}
