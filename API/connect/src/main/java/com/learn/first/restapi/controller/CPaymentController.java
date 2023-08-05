package com.learn.first.restapi.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.model.CPayment;
import com.learn.first.restapi.repository.IPaymentRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CPaymentController {
    @Autowired
    IPaymentRepository pIPaymentRepository;

    @GetMapping("/payment/all")
    public ResponseEntity<List<CPayment>> getAllPayments() {

        try {
            List<CPayment> pPayments = new ArrayList<CPayment>();
            pIPaymentRepository.findAll().forEach(pPayments::add);
            return new ResponseEntity<>(pPayments, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
