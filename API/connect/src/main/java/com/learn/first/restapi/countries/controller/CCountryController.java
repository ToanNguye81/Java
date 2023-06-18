package com.learn.first.restapi.countries.controller;

import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.countries.model.CCountry;
import com.learn.first.restapi.countries.model.CRegion;
import com.learn.first.restapi.countries.repository.ICountryRepository;
import com.learn.first.restapi.countries.repository.IRegionRepository;

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

    @Autowired
    IRegionRepository pIRegionRepository;

    // Get country by id
    @GetMapping("/country/details/{id}")
    public CCountry getCountryById(@PathVariable Long id) {
        // find country by id
        if (pICountryRepository.findById(id).isPresent())
            return pICountryRepository.findById(id).get();
        else
            return null;
    }

    @GetMapping(value = "/country/all")
    public ResponseEntity<List<CCountry>> getAllCountry(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        // tạo ra một đối tượng Pageable để đại diện cho thông tin về phân trang.
        Pageable pageable = PageRequest.of(page, size);
        // truy vấn CSDL và trả về một trang của đối tượng CCountry với thông tin trang
        Page<CCountry> countryPage = pICountryRepository.findAll(pageable);
        // để lấy danh sách các đối tượng
        List<CCountry> countryList = countryPage.getContent();
        // Đếm tổng phần tử
        Long totalElement = countryPage.getTotalElements();
        // Trả về thành công
        return ResponseEntity.ok()
                .header("totalCount", String.valueOf(totalElement))
                .body(countryList);
    }

    // Create new country
    @PostMapping(value = "/country/create")
    public ResponseEntity<Object> createCountry(@RequestBody CCountry pCountry) {
        try {
            CCountry newRole = new CCountry();
            newRole.setCountryName(pCountry.getCountryName());
            newRole.setCountryCode(pCountry.getCountryCode());
            newRole.setRegions(pCountry.getRegions());
            CCountry savedCountry = pICountryRepository.save(newRole);
            return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update country by id
    @PutMapping(value = "/country/update/{id}")
    public ResponseEntity<Object> updateCountry(@PathVariable Long id, @RequestBody CCountry pCountry) {
        // find country by id
        Optional<CCountry> countryData = pICountryRepository.findById(id);
        if (countryData.isPresent()) {
            // get existed country
            CCountry newCountry = countryData.get();
            // update country
            newCountry.setCountryName(pCountry.getCountryName());
            newCountry.setCountryCode(pCountry.getCountryCode());
            newCountry.setRegions(pCountry.getRegions());
            CCountry savedCountry = pICountryRepository.save(newCountry);
            // return
            return new ResponseEntity<>(savedCountry, HttpStatus.OK);
        } else {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }

    // Delete Country by Id
    @DeleteMapping("/country/delete/{id}")
    public ResponseEntity<Object> deleteCountryById(@PathVariable Long id) {
        try {
            pICountryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get the count of record
    @GetMapping("/country-count")
    public Long countCountry() {
        return pICountryRepository.count();
    }

    // Check country in database
    @GetMapping("/country/check/{id}")
    public boolean checkCountryById(@PathVariable Long id) {
        return pICountryRepository.existsById(id);
    }

    // Return the country containing the specified code
    @GetMapping("/country/containing-code/{code}")
    public CCountry getCountryByContainingCode(@PathVariable String code) {
        return pICountryRepository.findByCountryCodeContaining(code);
    }

    // Get Regions by countryId
    @GetMapping("/country/{countryId}/region")
    public List<CRegion> getRegionsByCountryId(@PathVariable Long countryId) {
        return pIRegionRepository.findByCountry_Id(countryId);
    }

}
