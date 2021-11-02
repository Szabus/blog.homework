package com.example.blog.homework.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String getHome() {
        return "Welcome Home";
    }
}
