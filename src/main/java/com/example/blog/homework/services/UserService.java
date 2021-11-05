package com.example.blog.homework.services;

import com.example.blog.homework.models.BlogUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    private PasswordEncoder encoder;

    @Autowired
    public UserService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return em.createQuery("SELECT user FROM BlogUser user WHERE user.username = :name", BlogUser.class)
                .setParameter("name", username)
                .getSingleResult();
    }


    public BlogUser getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof BlogUser) {
                return (BlogUser) principal;
            }
        }
        return null;
    }

    @Transactional
    public List<BlogUser> getAllUsers() {
        return em.createQuery("SELECT user FROM BlogUser user", BlogUser.class)
                .getResultList();
    }

    @Transactional
    public BlogUser getOneUser(String username) {
        try {
            return (BlogUser) loadUserByUsername(username);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public BlogUser registerUser(BlogUser user){

        user.setPassword(encoder.encode(user.getPassword()));
        em.persist(user);
        return user;
    }
}
