package com.learn.first.restapi.address.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.address.model.CProvince;
import com.learn.first.restapi.address.repository.IProvinceRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CProvinceController {

    @Autowired
    IProvinceRepository pIProvinceRepository;

    @GetMapping("/provinces")
    public ResponseEntity<List<CProvince>> getAllProvinces() {

        try {
            List<CProvince> pProvinces = new ArrayList<CProvince>();

            pIProvinceRepository.findAll().forEach(pProvinces::add);

            return new ResponseEntity<>(pProvinces, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
