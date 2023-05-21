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
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CCountryController {
    @Autowired
    ICountryRepository pICountryRepository;

    @GetMapping("/countries")
    public ResponseEntity<List<CCountry>> getAllCountrys() {

        try {
            List<CCountry> pCountrys = new ArrayList<CCountry>();
            pICountryRepository.findAll().forEach(pCountrys::add);
            return new ResponseEntity<>(pCountrys, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/voucher5")
    public ResponseEntity<List<CCountry>> getCountrys(
            @RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam(value = "size", defaultValue = "5") String size) {

        try {
            Pageable pageWithFiveElements = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
            List<CCountry> pCountrys = new ArrayList<CCountry>();
            pICountryRepository.findAll(pageWithFiveElements).forEach(pCountrys::add);
            return new ResponseEntity<>(pCountrys, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
