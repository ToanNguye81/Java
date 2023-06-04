package com.learn.first.restapi.address.controller;

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

import com.learn.first.restapi.address.model.CDistrict;
import com.learn.first.restapi.address.model.CWard;
import com.learn.first.restapi.address.repository.IDistrictRepository;
import com.learn.first.restapi.address.repository.IWardRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CWardController {

    @Autowired
    IDistrictRepository pIDistrictRepository;
    @Autowired
    IWardRepository pIWardRepository;

    // Get ward by id
    @GetMapping(value = "/ward/details/{id}")
    public CWard getWardById(@PathVariable Integer id) {
        if (pIWardRepository.findById(id).isPresent()) {
            return pIWardRepository.findById(id).get();
        } else {
            return null;
        }
    }

    // Get all wards
    @GetMapping("/ward/all")
    public List<CWard> getAllWard() {
        return pIWardRepository.findAll();
    }

    // Create new ward
    @PostMapping(value = "/ward/create/{districtId}")
    public ResponseEntity<Object> createWard(@PathVariable("districtId") Integer districtId,
            @RequestBody CWard pWard) {
        try {
            // Find district by id
            Optional<CDistrict> districtData = pIDistrictRepository.findById(districtId);
            System.out.println(districtData);
            if (districtData.isPresent()) {
                CWard newRole = new CWard();
                // TODO here
                CDistrict district = districtData.get();
                newRole.setDistrict(district);
                newRole.setName(pWard.getName());
                newRole.setPrefix(pWard.getPrefix());
                CWard savedRole = pIWardRepository.save(newRole);
                return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
                    .body("Failed to Create specified Ward: " + e.getCause().getCause().getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Update ward by id
    @PutMapping(value = "/ward/update/{id}")
    public ResponseEntity<Object> updateWardById(@PathVariable Integer id,
            @RequestBody CWard pWard) {
        Optional<CWard> wardData = pIWardRepository.findById(id);
        if (wardData.isPresent()) {
            CWard newWard = wardData.get();
            newWard.setName(pWard.getName());
            newWard.setPrefix(pWard.getPrefix());
            CWard savedWard = pIWardRepository.save(newWard);
            return new ResponseEntity<>(savedWard, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        }
    }

    // delete ward by id
    @DeleteMapping(value = "/ward/delete/{id}")
    public ResponseEntity<Object> deleteWardById(@PathVariable Integer id) {
        try {
            pIWardRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
