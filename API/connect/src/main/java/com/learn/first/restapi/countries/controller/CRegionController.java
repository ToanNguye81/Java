package com.learn.first.restapi.countries.controller;

import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.countries.model.CCountry;
import com.learn.first.restapi.countries.model.CRegion;
import com.learn.first.restapi.countries.repository.ICountryRepository;
import com.learn.first.restapi.countries.repository.IRegionRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    // Get region by id
    @GetMapping("/region/details/{id}")
    public CRegion getRegionById(@PathVariable Long id) {
        // find region with id success
        if (pIRegionRepository.findById(id).isPresent())
            return pIRegionRepository.findById(id).get();
        else
            return null;
    }

    @GetMapping("/region/all")
    public List<CRegion> getAllRegion() {
        return pIRegionRepository.findAll();
    }

    // POST METHOD
    @PostMapping(value = "/region/create/{id}")
    public ResponseEntity<Object> createRegion(@PathVariable("id") Long id, @RequestBody CRegion pRegion) {
        try {
            // Find country by id
            Optional<CCountry> countryData = pICountryRepository.findById(id);
            System.out.println(countryData);
            if (countryData.isPresent()) {
                CRegion newRole = new CRegion();
                // TODO here
                CCountry country = countryData.get();
                newRole.setCountry(country);
                newRole.setRegionName(pRegion.getRegionName());
                newRole.setRegionCode(pRegion.getRegionCode());
                CRegion savedRole = pIRegionRepository.save(newRole);
                return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Voucher: " + e.getCause().getCause().getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // PUT METHOD
    @PutMapping(value = "/region/update/{id}")
    public ResponseEntity<Object> updateRegion(@PathVariable Long id, @RequestBody CRegion pRegion) {
        // TODO: process POST request
        Optional<CRegion> regionData = pIRegionRepository.findById(id);
        if (regionData.isPresent()) {
            CRegion newRegion = regionData.get();
            newRegion.setRegionName(pRegion.getRegionName());
            newRegion.setRegionCode(pRegion.getRegionCode());
            CRegion savedRegion = pIRegionRepository.save(newRegion);
            return new ResponseEntity<>(savedRegion, HttpStatus.OK);
        } else {
            // TODO: handle exception
            System.out.println("not find region by id");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/region/delete/{id}")
    public ResponseEntity<Object> deleteRegionById(@PathVariable Long id) {
        try {
            pIRegionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // GET METHOD
    // get Region by country code
    // @GetMapping(value = "/regions")
    // public ResponseEntity<Set<CRegion>> getRegionByCountryCode(
    // @RequestParam(value = "countryCode", required = false) String countryCode) {
    // try {
    // if (countryCode != null) {
    // // find Country base on countryCode
    // CCountry vCountry = pICountryRepository.findByCountryCode(countryCode);
    // // Return regions list
    // } else {
    // {
    // // find all regions
    // Set<CRegion> allRegions = new HashSet<>();
    // List<CCountry> countries = pICountryRepository.findAll();

    // // create list
    // for (CCountry country : countries) {
    // }
    // // Return regions list
    // return new ResponseEntity<>(allRegions, HttpStatus.OK);
    // }
    // }

    // } catch (Exception e) {
    // // TODO: handle exception
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
}
