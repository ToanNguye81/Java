package com.learn.first.restapi.regions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.regions.model.CRegion;

public interface IRegionRepository extends JpaRepository<CRegion, Integer> {

    CRegion findByRegionCodeContaining(String code);

    List<CRegion> findByCountryId(Long countryId);

}
