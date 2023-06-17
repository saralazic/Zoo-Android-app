package com.example.pandicazoovrt.tickets;

import java.util.ArrayList;
import java.util.Date;

public class Comment {
    private String author;
    private Date date;
    private String text;
    private Comment[] replies;

    public Comment(String author, Date date, String text, Comment[] replies) {
        this.author = author;
        this.date = date;
        this.text = text;
        this.replies = replies;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment[] getReplies() {
        return replies;
    }

    public void setReplies(Comment[] replies) {
        this.replies = replies;
    }
}
