package com.example.blog.homework.services;

import com.example.blog.homework.models.Blog;
import com.example.blog.homework.models.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BlogService {

    UserService userService;

    @Autowired
    public BlogService(UserService userService) {
        this.userService = userService;
    }

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Blog> getAllBlogs() {
        return em.createQuery("SELECT blog FROM Blog blog", Blog.class)
                .getResultList();
    }

    @Transactional
    public void createBlog(Blog blog){
        BlogUser user;
        user = userService.getLoggedInUser();
       blog.setAuthor(user);
       em.persist(blog);
    }
}
