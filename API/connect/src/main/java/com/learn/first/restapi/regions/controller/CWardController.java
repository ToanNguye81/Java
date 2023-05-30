package com.learn.first.restapi.regions.controller;

import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.regions.model.CDistrict;
import com.learn.first.restapi.regions.model.CWard;
import com.learn.first.restapi.regions.repository.IDistrictRepository;
import com.learn.first.restapi.regions.repository.IWardRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CWardController {

    @Autowired
    IDistrictRepository pDistrictRepository;
    @Autowired
    IWardRepository pWardRepository;

    @GetMapping(value = "/wards")
    public ResponseEntity<Set<CWard>> getWardByDistrictId(
            @RequestParam(value = "districtId", required = false) int districtId) {
        try {
            if (districtId != 0) {
                // find District base on districtId - name 1 time
                CDistrict vDistrict = pDistrictRepository.findById(districtId);
                System.out.println("=======================================");
                System.out.println("vDistrict : " + vDistrict);
                // Return wards list
                return new ResponseEntity<>(vDistrict.getWards(), HttpStatus.OK);
            } else {
                {
                    // find all wards
                    Set<CWard> allWards = new HashSet<>();
                    List<CDistrict> districts = pDistrictRepository.findAll();

                    // create list
                    for (CDistrict district : districts) {
                        allWards.addAll(district.getWards());
                    }
                    // Return wards list
                    return new ResponseEntity<>(allWards, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
