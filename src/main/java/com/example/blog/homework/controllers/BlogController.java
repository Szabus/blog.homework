package com.example.blog.homework.controllers;

import com.example.blog.homework.models.Blog;
import com.example.blog.homework.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {


    private BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @GetMapping("/allblogs")
    public ResponseEntity<List<Blog>> getAllBlogs() {
            return new ResponseEntity<>(service.getAllBlogs(), HttpStatus.OK);
        }

    @PostMapping("/blogs")
    public ResponseEntity<String> createBlog(@RequestBody Blog blog) {
        service.createBlog(blog);
        return new ResponseEntity<>("Blog added.", HttpStatus.OK);
    }
}
