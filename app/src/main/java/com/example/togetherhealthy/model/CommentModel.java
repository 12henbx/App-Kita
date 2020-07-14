package com.example.togetherhealthy.model;

public class CommentModel {
    private String username;
    private String userPictureUrl;
    private String userComment;
    private Integer timestamp;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserPictureUrl(String userPictureUrl) {
        this.userPictureUrl = userPictureUrl;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPictureUrl() {
        return userPictureUrl;
    }

    public String getUserComment() {
        return userComment;
    }

    public Integer getTimestamp() {
        return timestamp;
    }
}
