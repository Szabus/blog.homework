package com.example.blog.homework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public ResponseEntity<String> getHome() {
        return new ResponseEntity<>("Welcome Home", HttpStatus.OK);
    }
}
