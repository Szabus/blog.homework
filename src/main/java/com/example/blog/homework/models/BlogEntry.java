package com.example.blog.homework.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogEntry {

    @Id
    @GeneratedValue
    private int id;
    private String entry;
    @Enumerated(EnumType.STRING)
    private EntryStatus status;
    @ManyToOne
    private Blog blog;
    @OneToMany(mappedBy = "blogEntry")
    private List<BlogComment> commentList;

    public BlogEntry() {
        commentList = new ArrayList<>();
    }

    public BlogEntry(int id, String entry, EntryStatus status, Blog blog) {
        this.id = id;
        this.entry = entry;
        this.status = status;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public EntryStatus getStatus() {
        return status;
    }

    public void setStatus(EntryStatus status) {
        this.status = status;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
