package com.learn.first.restapi.profiles.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.profiles.model.CProfile;
import com.learn.first.restapi.profiles.repository.IProfileRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CProfileController {
    @Autowired
    IProfileRepository pIProfileRepository;

    @GetMapping("/profile/all")
    public ResponseEntity<List<CProfile>> getAllProfiles() {

        try {
            List<CProfile> pProfiles = new ArrayList<CProfile>();
            pIProfileRepository.findAll().forEach(pProfiles::add);
            return new ResponseEntity<>(pProfiles, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
