package com.learn.first.restapi.drinks.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.drinks.model.CDrink;
import com.learn.first.restapi.drinks.repository.IDrinkRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CDrinkController {
    @Autowired
    IDrinkRepository pIDrinkRepository;

    @GetMapping("/drinks")
    public ResponseEntity<List<CDrink>> getAllDrinks() {

        try {
            List<CDrink> pDrinks = new ArrayList<CDrink>();
            pIDrinkRepository.findAll().forEach(pDrinks::add);
            return new ResponseEntity<>(pDrinks, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
