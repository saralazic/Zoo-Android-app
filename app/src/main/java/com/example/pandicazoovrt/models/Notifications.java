package com.example.pandicazoovrt.models;

import java.util.Date;
import java.util.UUID;

public class Notifications {
    private String username;
    private UUID id;
    private boolean seen;
    private String text;
    private Date date;

    public Notifications(String username, boolean seen, String text, Date date) {
        this.username = username;
        this.seen = seen;
        this.text = text;
        this.date = date;
        this.id = UUID.randomUUID();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
