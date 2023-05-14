package com.devcamp.hello.rest;

import java.text.*;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @CrossOrigin
    @GetMapping("/devcamp-welcome")
    public String nice() {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        Date now = new Date();
        return String.format("Have a nice date is %s", dateFormat.format(now));
    }
}