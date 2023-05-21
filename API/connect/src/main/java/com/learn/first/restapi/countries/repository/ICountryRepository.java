package com.learn.first.restapi.countries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.first.restapi.countries.model.CCountry;

public interface ICountryRepository extends JpaRepository<CCountry, Long> {

}
