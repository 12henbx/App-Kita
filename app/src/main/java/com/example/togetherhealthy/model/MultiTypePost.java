package com.example.togetherhealthy.model;

import android.net.Uri;

public class MultiTypePost {
    private String username;
    private String title;
    private String article;
    private Uri url_photo;
    private String url_video;
    private String Category;
    private int voteCount;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Uri getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(Uri url_photo) {
        this.url_photo = url_photo;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
