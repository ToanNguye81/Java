package com.learn.first.restapi.hashTags.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.hashTags.model.CHashTag;
import com.learn.first.restapi.hashTags.repository.IHashTagRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CHashTagController {
    @Autowired
    IHashTagRepository pIHashTagRepository;

    @GetMapping("/hashTag/all")
    public ResponseEntity<List<CHashTag>> getAllHashTags() {

        try {
            List<CHashTag> pHashTags = new ArrayList<CHashTag>();
            pIHashTagRepository.findAll().forEach(pHashTags::add);
            return new ResponseEntity<>(pHashTags, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
