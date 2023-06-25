package com.learn.first.restapi.regions.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.regions.model.CRegion;

public interface IRegionRepository extends JpaRepository<CRegion, Long> {

    CRegion findByRegionCodeContaining(String code);

    List<CRegion> findByCountryId(Long countryId);

    Optional<CRegion> findById(Integer id);

    void deleteById(Integer id);

}
