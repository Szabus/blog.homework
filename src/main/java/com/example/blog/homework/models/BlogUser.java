package com.example.blog.homework.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class BlogUser implements UserDetails {

    @Id
    private String userName;
    private String password;
    private String nickName;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    private boolean isLocked;
    @OneToMany(mappedBy = "author")
    private List<Blog> blogList;


    public BlogUser() {
        blogList = new ArrayList<>();
    }

    public BlogUser(String userName, String password, String nickName, Authority authority) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.authority = authority;
    }

    public BlogUser(String userName, String password, String nickName, Authority authority, boolean isLocked) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.authority = authority;
        this.isLocked = isLocked;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (UserAuth auth : authority.AUTHS) {
            list.add(new SimpleGrantedAuthority(auth.toString()));
        }

        return list;
    }
    @Override
    public String getUsername() {
        return userName;
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

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
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
