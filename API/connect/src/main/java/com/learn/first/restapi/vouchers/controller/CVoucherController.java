package com.learn.first.restapi.vouchers.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.vouchers.model.CVoucher;
import com.learn.first.restapi.vouchers.repository.IVoucherRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CVoucherController {
    @Autowired
    IVoucherRepository pIVoucherRepository;

    @GetMapping("/vouchers")
    public ResponseEntity<List<CVoucher>> getAllVouchers() {

        try {
            List<CVoucher> pVouchers = new ArrayList<CVoucher>();
            pIVoucherRepository.findAll().forEach(pVouchers::add);
            return new ResponseEntity<>(pVouchers, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
