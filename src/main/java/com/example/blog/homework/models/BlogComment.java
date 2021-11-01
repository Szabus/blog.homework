package com.example.blog.homework.models;

import javax.persistence.*;

@Entity
public class BlogComment {

    @Id
    @GeneratedValue
    private int commentId;
    private String comment;
    @ManyToOne
    private BlogEntry blogEntry;
    @OneToOne
    private BlogComment replyId;

    public BlogComment() {
    }

    public BlogComment(int commentId, String comment, BlogEntry blogEntry, BlogComment replyId) {
        this.commentId = commentId;
        this.comment = comment;
        this.blogEntry = blogEntry;
        this.replyId = replyId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(BlogEntry blogEntry) {
        this.blogEntry = blogEntry;
    }

    public BlogComment getReplyId() {
        return replyId;
    }

    public void setReplyId(BlogComment replyId) {
        this.replyId = replyId;
    }
}
