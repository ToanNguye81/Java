package com.learn.first.restapi.orders.controller;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.orders.model.COrder;
import com.learn.first.restapi.orders.repository.IOrderRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class COrderController {
    // @Autowired
    // IOrderRepository pOrderRepository;

    // @GetMapping("/orders")
    // public ResponseEntity<List<COrder>> getAllOrders() {

    // try {
    // List<COrder> pOrders = new ArrayList<COrder>();

    // pOrderRepository.findAll().forEach(pOrders::add);

    // return new ResponseEntity<>(pOrders, HttpStatus.OK);
    // } catch (Exception e) {
    // // TODO: handle exception
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}
