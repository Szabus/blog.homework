package com.example.blog.homework.controllers;

import com.example.blog.homework.models.Blog;
import com.example.blog.homework.models.BlogUser;
import com.example.blog.homework.repositories.UserRepository;
import com.example.blog.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = {"/", "/home"})
    public String getHello() {
        return "hello";
    }

    @GetMapping("/user")
    public BlogUser getLoggedInUser() {
        return service.getLoggedInUser();
    }

    // csak admin
    @GetMapping("/users")
    public List<BlogUser> getAllUsers() {
        return service.getAllUsers();
    }

    // akár user, akár admin
    // ezt is csak admin
    @GetMapping(value = {"/users/", "/users/{username}"})
    public BlogUser getOneUser(
            @PathVariable("username") String username
    ) {
        if (username != null) {
            return service.getOneUser(username);
        }
        return null;
    }

    @GetMapping("/register")
    public String registerUser() {
        boolean registered = service.registerUsers();
        if (registered) {
            return "ok";
        }
        return "not ok";
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