package com.learn.first.restapi.countries.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.countries.model.CRegion;

public interface IRegionRepository extends JpaRepository<CRegion, Long> {
    Optional<CRegion> findById(Integer id);

    CRegion findByRegionCodeContaining(String code);

    List<CRegion> findByCountryId(Long countryId);

}
