package com.example.blog.homework.controllers;

import com.example.blog.homework.models.Blog;
import com.example.blog.homework.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping
    public List<Blog> getAllBlogs() {
        return null;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/blog")
    public String createBlog(@RequestBody Blog blog) {
        service.createBlog(blog);
        return "Blog elkészült";
    }
}
