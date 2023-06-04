package com.learn.first.restapi.address.controller;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.address.model.CDistrict;
import com.learn.first.restapi.address.model.CProvince;
import com.learn.first.restapi.address.repository.IDistrictRepository;
import com.learn.first.restapi.address.repository.IProvinceRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CDistrictController {

    @Autowired
    IDistrictRepository pIDistrictRepository;
    @Autowired
    IProvinceRepository pIProvinceRepository;

    // get all district
    @GetMapping(value = "/district/all")
    public List<CDistrict> getAllDistrict() {
        return pIDistrictRepository.findAll();
    }

    // get district by id
    @GetMapping(value = "/district/details/{id}")
    public CDistrict getDistrictById(@PathVariable Integer id) {
        if (pIDistrictRepository.findById(id).isPresent()) {
            return pIDistrictRepository.findById(id).get();
        } else {
            return null;
        }
    }

    // create new district
    @PostMapping(value = "/district/create/{provinceId}")
    public ResponseEntity<Object> createDistrict(@PathVariable Integer provinceId,
            @RequestBody CDistrict pDistrict) {
        // TODO: process POST request
        try {
            Optional<CProvince> provinceData = pIProvinceRepository.findById(provinceId);
            if (provinceData.isPresent()) {
                CDistrict newDistrict = new CDistrict();
                newDistrict.setName(pDistrict.getName());
                newDistrict.setPrefix(pDistrict.getPrefix());
                CDistrict savedDistrict = pIDistrictRepository.save(newDistrict);
                return new ResponseEntity<>(savedDistrict, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Ward: " + e.getCause().getCause().getMessage());

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // update distric
    @PutMapping(value = "/district/update/{id}")
    public ResponseEntity<Object> updateDistrictById(@PathVariable Integer id, @RequestBody CDistrict pDistrict) {
        // TODO: process PUT request
        Optional<CDistrict> districtData = pIDistrictRepository.findById(id);
        if (districtData.isPresent()) {
            CDistrict newDistrict = districtData.get();
            newDistrict.setName(pDistrict.getName());
            newDistrict.setPrefix(pDistrict.getPrefix());
            CDistrict savedDistrict = pIDistrictRepository.save(newDistrict);
            return new ResponseEntity<>(savedDistrict, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete District by id
    @DeleteMapping("/district/delete/{id}")
    public ResponseEntity<Object> deleteDistrictById(@PathVariable Integer id) {
        try {
            pIDistrictRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
