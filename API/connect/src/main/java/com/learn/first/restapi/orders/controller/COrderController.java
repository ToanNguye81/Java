// package com.learn.first.restapi.orders.controller;

// import org.springframework.http.HttpStatus;

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.learn.first.restapi.countries.model.CCountry;
// import com.learn.first.restapi.countries.repository.ICountryRepository;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @CrossOrigin
// @RestController
// @RequestMapping("/")
// public class COrderController {

// @Autowired
// IRegionRepository pIRegionRepository;

// @GetMapping(value = "/orders")
// public ResponseEntity<Set<COrder>> getRegionByCountryCode(
// @RequestParam(value = "orderCode", required = false) String orderCode) {
// try {
// if (orderCode != null) {
// // find Country base on orderCode
// CCountry vCountry = pICountryRepository.findByCountryCode(orderCode);
// // Return orders list
// return new ResponseEntity<>(vCountry.getRegions(), HttpStatus.OK);
// } else {
// {
// // find all orders
// Set<COrder> allRegions = new HashSet<>();
// List<CCountry> countries = pICountryRepository.findAll();

// // create list
// for (CCountry order : countries) {
// allRegions.addAll(order.getRegions());
// }
// // Return orders list
// return new ResponseEntity<>(allRegions, HttpStatus.OK);
// }
// }

// } catch (Exception e) {
// // TODO: handle exception
// return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
// }
// }

// @GetMapping("/wards")
// public ResponseEntity<List<CWard>> getAllWards() {
// try {
// List<CWard> pWards = new ArrayList<CWard>();
// pWardRepository.findAll().forEach(pWards::add);
// return new ResponseEntity<>(pWards, HttpStatus.OK);
// } catch (Exception e) {
// // TODO: handle exception
// return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
// }
// }
// }
