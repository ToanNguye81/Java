package com.learn.first.restapi.customers.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.customers.model.CCustomer;
import com.learn.first.restapi.customers.repository.ICustomerRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CCustomerController {
    @Autowired
    ICustomerRepository pICustomerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<CCustomer>> getAllCustomers() {

        try {
            List<CCustomer> pCustomers = new ArrayList<CCustomer>();
            pICustomerRepository.findAll().forEach(pCustomers::add);
            return new ResponseEntity<>(pCustomers, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
