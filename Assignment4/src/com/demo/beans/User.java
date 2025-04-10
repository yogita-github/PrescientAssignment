package com.demo.beans;

public class User {
    private String username;
    private boolean online;

    public User(String username) {
        this.username = username;
        this.online = true;
    }

    public String getUsername() {
        return username;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
