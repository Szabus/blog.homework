package com.example.blog.homework.services;

import com.example.blog.homework.models.Blog;
import com.example.blog.homework.models.BlogUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class BlogService {

    UserService userService;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createBlog(Blog blog){
       blog.setAuthor(userService.getLoggedInUser());
       em.persist(blog);
    }
}
