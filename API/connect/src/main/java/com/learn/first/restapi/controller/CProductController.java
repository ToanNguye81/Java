package com.learn.first.restapi.controller;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;

import com.learn.first.restapi.model.CProduct;
import com.learn.first.restapi.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CProductController {
    @Autowired
    IProductRepository pIProductRepository;

    @GetMapping("/products")
    public ResponseEntity<List<CProduct>> getAllProducts() {

        try {
            List<CProduct> pProducts = new ArrayList<CProduct>();
            pIProductRepository.findAll().forEach(pProducts::add);
            return new ResponseEntity<>(pProducts, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
