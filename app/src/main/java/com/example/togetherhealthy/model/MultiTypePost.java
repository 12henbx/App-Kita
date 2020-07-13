package com.example.togetherhealthy.model;

public class MultiTypePost {
    private String username;
    private String article;
    private int url_photo;
    private String url_video;

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

    public int getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(int url_photo) {
        this.url_photo = url_photo;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }
}
