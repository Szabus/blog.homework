package com.example.blog.homework.controllers;

import com.example.blog.homework.models.BlogUser;
import com.example.blog.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/user")
    public BlogUser getLoggedInUser() {
        return service.getLoggedInUser();
    }

    @GetMapping("/users")
    public List<BlogUser> getAllUsers() {
        return service.getAllUsers();
    }


    @GetMapping(value = {"/users/", "/users/{username}"})
    public BlogUser getOneUser(
            @PathVariable("username") String username
    ) {
        if (username != null) {
            return service.getOneUser(username);
        }
        return null;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody BlogUser user) {
        service.registerUser(user);
        return "Felhasználó rögzítve";
    }
}