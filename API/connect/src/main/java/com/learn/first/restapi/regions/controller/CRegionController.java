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

import com.learn.first.restapi.countries.model.CCountry;
import com.learn.first.restapi.countries.repository.ICountryRepository;
import com.learn.first.restapi.regions.model.CRegion;
import com.learn.first.restapi.regions.repository.IRegionRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CRegionController {

    @Autowired
    IRegionRepository pIRegionRepository;
    @Autowired
    ICountryRepository pICountryRepository;

    /*
     * ResponseEntity: Là một lớp trong Spring Framework được sử dụng để đóng gói
     * kết quả trả về từ một API endpoint. Cho phép thiết lập các thông tin
     * phản hồi như body, headers và mã trạng thái HTTP
     * Set được sử dụng thay vì List hoặc ArrayList vì yêu cầu
     * đặc biệt của một tập hợp các đối tượng duy nhất (không có phần tử trùng lặp).
     * Body được đóng gói là một tập hợp (Set) các đối tượng kiểu CRegion. Set đảm
     * bảo rằng không có phần tử trùng lặp trong tập hợp.
     */

    @GetMapping(value = "/regions")
    public ResponseEntity<Set<CRegion>> getRegionByCountryCode(
            @RequestParam(value = "countryCode", required = false) String countryCode) {
        try {
            if (countryCode != null) {
                // find Country base on countryCode
                CCountry vCountry = pICountryRepository.findByCountryCode(countryCode);
                // Return regions list
                return new ResponseEntity<>(vCountry.getRegions(), HttpStatus.OK);
            } else {
                {
                    // find all regions
                    Set<CRegion> allRegions = new HashSet<>();
                    List<CCountry> countries = pICountryRepository.findAll();

                    // create list
                    for (CCountry country : countries) {
                        allRegions.addAll(country.getRegions());
                    }
                    // Return regions list
                    return new ResponseEntity<>(allRegions, HttpStatus.OK);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
