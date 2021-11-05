package com.example.blog.homework.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class BlogUser implements UserDetails {

    @Id
    private String username;
    private String password;
    private String nickName;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private boolean isLocked;
    @OneToMany(mappedBy = "author")
    private List<Blog> blogList;


    public BlogUser() {
        blogList = new ArrayList<>();
    }

    public BlogUser(String username, String password, String nickName, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.userRole = userRole;
    }

    public BlogUser(String username, String password, String nickName, UserRole userRole, boolean isLocked) {
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.userRole = userRole;
        this.isLocked = isLocked;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRole.getAuths();
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isEnabled() {
        return !isLocked;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
