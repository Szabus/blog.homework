package com.example.blog.homework.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {

    @Id
    private String blogName;
    @ManyToOne
    private BlogUser author;
    @Enumerated(EnumType.STRING)
    private BlogCategory category;
    @Enumerated(EnumType.STRING)
    private BlogColor blogColor;
    @CreationTimestamp
    private LocalDateTime regTime;
    private boolean isLocked;
    @OneToMany(mappedBy = "blog")
    private List<BlogEntry> entryList;

    public Blog() {
        entryList = new ArrayList<>();
    }

    public Blog(String blogName, BlogUser author, BlogCategory category, BlogColor blogColor,
                LocalDateTime regTime, boolean isLocked, List<BlogEntry> entryList) {
        this.blogName = blogName;
        this.author = author;
        this.category = category;
        this.blogColor = blogColor;
        this.regTime = regTime;
        this.isLocked = isLocked;
        this.entryList = entryList;
    }

    public Blog(String blogName, BlogCategory category, BlogColor blogColor) {
        this.blogName = blogName;
        this.category = category;
        this.blogColor = blogColor;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public BlogUser getAuthor() {
        return author;
    }

    public void setAuthor(BlogUser author) {
        this.author = author;
    }

    public BlogCategory getCategory() {
        return category;
    }

    public void setCategory(BlogCategory category) {
        this.category = category;
    }

    public BlogColor getBlogColor() {
        return blogColor;
    }

    public void setBlogColor(BlogColor blogColor) {
        this.blogColor = blogColor;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
