package com.learn.first.restapi.countries.controller;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

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

    // Create new region
    @PostMapping(value = "/region/create/{countryId}")
    public ResponseEntity<Object> createRegion(@PathVariable("countryId") Long countryId,
            @RequestBody CRegion pRegion) {
        try {
            // Find country by id
            Optional<CCountry> countryData = pICountryRepository.findById(countryId);
            // create
            if (countryData.isPresent()) {
                CCountry country = countryData.get();
                CRegion newRegion = new CRegion();
                newRegion.setCountry(country);
                newRegion.setRegionName(pRegion.getRegionName());
                newRegion.setRegionCode(pRegion.getRegionCode());
                CRegion savedRole = pIRegionRepository.save(newRegion);
                return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Voucher: " + e.getCause().getCause().getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Update region by id
    @PutMapping(value = "/region/update/{id}")
    public ResponseEntity<Object> updateRegion(@PathVariable Integer id, @RequestBody CRegion pRegion) {
        // find region by id
        Optional<CRegion> regionData = pIRegionRepository.findById(id);
        // update new region
        if (regionData.isPresent()) {
            CRegion newRegion = regionData.get();
            newRegion.setRegionName(pRegion.getRegionName());
            newRegion.setRegionCode(pRegion.getRegionCode());
            CRegion savedRegion = pIRegionRepository.save(newRegion);
            return new ResponseEntity<>(savedRegion, HttpStatus.OK);
        } else {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete region by Id
    @DeleteMapping("/region/delete/{id}")
    public ResponseEntity<Object> deleteRegionById(@PathVariable Long id) {
        try {
            pIRegionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}