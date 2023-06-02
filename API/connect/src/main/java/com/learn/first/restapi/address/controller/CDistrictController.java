package com.learn.first.restapi.address.controller;

import org.springframework.http.HttpStatus;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.address.model.CDistrict;
import com.learn.first.restapi.address.model.CProvince;
import com.learn.first.restapi.address.repository.IDistrictRepository;
import com.learn.first.restapi.address.repository.IProvinceRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CDistrictController {

    @Autowired
    IDistrictRepository pIDistrictRepository;
    @Autowired
    IProvinceRepository pIProvinceRepository;

    @GetMapping(value = "/districts")
    public ResponseEntity<Set<CDistrict>> getDistrictByCode(
            @RequestParam(value = "provinceCode", required = false) String provinceCode) {
        try {
            if (provinceCode != null) {
                // find Province base on provinceCode
                CProvince vProvince = pIProvinceRepository.findByCode(provinceCode);
                // Return province list
                return new ResponseEntity<>(vProvince.getDistricts(), HttpStatus.OK);
            } else {
                {
                    // find all province
                    Set<CDistrict> allDistricts = new HashSet<>();
                    List<CProvince> provinces = pIProvinceRepository.findAll();

                    // create district list
                    for (CProvince province : provinces) {
                        allDistricts.addAll(province.getDistricts());
                    }
                    // Return province list
                    return new ResponseEntity<>(allDistricts, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
