package com.example.blog.homework.controllers;

import com.example.blog.homework.models.Blog;
import com.example.blog.homework.models.BlogUser;
import com.example.blog.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BlogUser> getLoggedInUser() {
        return new ResponseEntity<>(service.getLoggedInUser(), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<BlogUser>> getAllUsers() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping(value = {"/user/", "/user/{username}"})
    public ResponseEntity<BlogUser> getOneUser(
            @PathVariable("username") String username
    ) {
        if (username != null) {
            return new ResponseEntity<>(service.getOneUser(username), HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody BlogUser user) {
        service.registerUser(user);
        return new ResponseEntity<>("User added.",HttpStatus.OK);
    }
}