package com.learn.first.restapi.controller;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.first.restapi.model.CPost;
import com.learn.first.restapi.repository.IPostRepository;

import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CPostController {
    @Autowired
    IPostRepository pIPostRepository;

    @GetMapping("/post/all")
    public ResponseEntity<List<CPost>> getAllPosts() {

        try {
            List<CPost> pPosts = new ArrayList<CPost>();
            pIPostRepository.findAll().forEach(pPosts::add);
            return new ResponseEntity<>(pPosts, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
