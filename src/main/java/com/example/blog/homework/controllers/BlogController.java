package com.example.blog.homework.controllers;

import com.example.blog.homework.services.BlogService;
import com.example.blog.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {


    private BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/home"})
    public String getHome() {
        return "Welcome Home";
    }


// /blogs
    //○	method: GET
    //○	feladat: visszaadja az összes blogot az adatbázisból


    ///blogs
    //○	method: POST
    //○	@RequestBody Blog blog
    //○	feladat: új blogot rögzít az adatbázisba
    //○	megjegyzés: a felhasználónak be kell jelentkeznie új blog készítéséhez
}
