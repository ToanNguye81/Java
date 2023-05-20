package com.learn.first.restapi.vouchers.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/voucher5")
    public ResponseEntity<List<CVoucher>> getVouchers(
            @RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam(value = "size", defaultValue = "5") String size) {

        try {
            Pageable pageWithFiveElements = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
            List<CVoucher> pVouchers = new ArrayList<CVoucher>();
            pIVoucherRepository.findAll(pageWithFiveElements).forEach(pVouchers::add);
            return new ResponseEntity<>(pVouchers, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
