package com.learn.first.restapi.regions.controller;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.first.restapi.regions.model.CRegion;
import com.learn.first.restapi.regions.repository.IRegionRepository;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CRegionController {
    @Autowired
    IRegionRepository pIRegionRepository;

    @GetMapping("/regions")
    public ResponseEntity<List<CRegion>> getAllRegions() {

        try {
            List<CRegion> pRegions = new ArrayList<CRegion>();
            pIRegionRepository.findAll().forEach(pRegions::add);
            return new ResponseEntity<>(pRegions, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/country5")
    // public ResponseEntity<List<CRegion>> getRegions(
    // @RequestParam(value = "page", defaultValue = "1") String page,
    // @RequestParam(value = "size", defaultValue = "5") String size) {

    // try {
    // Pageable pageWithFiveElements = PageRequest.of(Integer.parseInt(page),
    // Integer.parseInt(size));
    // List<CRegion> pRegions = new ArrayList<CRegion>();
    // pIRegionRepository.findAll(pageWithFiveElements).forEach(pRegions::add);
    // return new ResponseEntity<>(pRegions, HttpStatus.OK);
    // } catch (Exception e) {
    // // TODO: handle exception
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}
