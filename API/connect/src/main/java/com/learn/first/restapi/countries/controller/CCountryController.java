package com.learn.first.restapi.countries.controller;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.first.restapi.countries.model.CCountry;
import com.learn.first.restapi.countries.repository.ICountryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CCountryController {
    @Autowired
    ICountryRepository pICountryRepository;

    // Get country by id
    @GetMapping("/country/details/{id}")
    public CCountry getCountryById(@PathVariable Long id) {
        // find country with id success
        if (pICountryRepository.findById(id).isPresent())
            return pICountryRepository.findById(id).get();
        else
            return null;
    }

    @GetMapping("/country/all")
    public List<CCountry> getAllCountry() {
        return pICountryRepository.findAll();
    }

    // POST METHOD
    @PostMapping(value = "/country/create")
    public ResponseEntity<Object> createCountry(@RequestBody CCountry pCountry) {
        // TODO: process POST request

        try {
            CCountry newRole = new CCountry();
            newRole.setCountryName(pCountry.getCountryName());
            newRole.setCountryCode(pCountry.getCountryCode());
            newRole.setRegions(pCountry.getRegions());
            CCountry savedCountry = pICountryRepository.save(newRole);
            return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/country/update/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable Long id, @RequestBody CCountry pCountry) {
        // TODO: process POST request
        Optional<CCountry> countryData = pICountryRepository.findById(id);
        if (countryData.isPresent()) {
            CCountry newCountry = countryData.get();
            newCountry.setCountryName(pCountry.getCountryName());
            newCountry.setCountryCode(pCountry.getCountryCode());
            newCountry.setRegions(pCountry.getRegions());
            CCountry savedCountry = pICountryRepository.save(newCountry);
            return new ResponseEntity<>(savedCountry, HttpStatus.OK);
        } else {
            // TODO: handle exception
            System.out.println("not find country by id");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/country/delete/{id}")
    public ResponseEntity<Object> deleteCountryById(@PathVariable Long id) {
        try {
            pICountryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // // GET METHOD Ver 1
    // @GetMapping("/countries")
    // public ResponseEntity<List<CCountry>> getAllCountries() {

    // try {
    // List<CCountry> pCountries = new ArrayList<CCountry>();

    // pICountryRepository.findAll().forEach(pCountries::add);

    // return new ResponseEntity<>(pCountries, HttpStatus.OK);
    // } catch (Exception e) {
    // // TODO: handle exception
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}
