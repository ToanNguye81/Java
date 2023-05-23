package com.learn.first.restapi.countries.controller;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.learn.first.restapi.countries.model.CCountry;
import com.learn.first.restapi.countries.repository.ICountryRepository;
import com.learn.first.restapi.regions.repository.IRegionRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CCountryController {
    @Autowired
    ICountryRepository pCountryRepository;

    @GetMapping("/countries")
    public ResponseEntity<List<CCountry>> getAllCountries() {

        try {
            List<CCountry> pCountries = new ArrayList<CCountry>();

            pCountryRepository.findAll().forEach(pCountries::add);

            return new ResponseEntity<>(pCountries, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
