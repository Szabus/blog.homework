package com.example.blog.homework.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum UserRole {

    USER(UserAuth.READ_BLOG, UserAuth.CREATE, UserAuth.WRITE, UserAuth.MODIFY_SELF, UserAuth.DELETE_SELF),
    MODERATOR(UserAuth.READ_ALL, UserAuth.CREATE,  UserAuth.WRITE, UserAuth.MODIFY_ALL, UserAuth.DELETE_SELF),
    ADMIN(UserAuth.READ_ALL, UserAuth.CREATE, UserAuth.WRITE, UserAuth.MODIFY_ALL, UserAuth.DELETE_ALL);

    private final UserAuth[] AUTHS;

    UserRole(UserAuth... auths) {
        AUTHS = auths;
    }

    public List<SimpleGrantedAuthority> getAuths() {
        List<SimpleGrantedAuthority> auths = new ArrayList<>();

        for (UserAuth auth : AUTHS) {
            auths.add(new SimpleGrantedAuthority(auth.toString()));
        }

        return auths;
    }
}
