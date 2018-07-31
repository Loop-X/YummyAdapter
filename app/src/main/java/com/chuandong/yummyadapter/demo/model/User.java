package com.chuandong.yummyadapter.demo.model;

public class User {

    private String userName;
    private Boolean isFollowed;

    public User(String userName, Boolean isFollowed) {
        this.userName = userName;
        this.isFollowed = isFollowed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getFollowed() {
        return isFollowed;
    }

    public void setFollowed(Boolean followed) {
        isFollowed = followed;
    }
}
