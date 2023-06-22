package com.learn.first.restapi.users.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.users.model.CUser;
import com.learn.first.restapi.users.repository.IUserRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CUserController {
    @Autowired
    IUserRepository pIUserRepository;

    @GetMapping("/users")
    public ResponseEntity<List<CUser>> getAllUsers() {

        try {
            List<CUser> pUsers = new ArrayList<CUser>();
            pIUserRepository.findAll().forEach(pUsers::add);
            return new ResponseEntity<>(pUsers, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}