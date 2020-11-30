package com.codeup.blog.models;

public class Post {
    private String title;
    private String body;

    public Post(){
    }

    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;       // Getter Title
    }
    public String getBody() {
        return body;        // Getter Body
    }

    public void setTitle(String title) {
        this.title = title;     // Setter Title
    }
    public void setBody(String body) {
        this.body = body;       // Setter Body
    }
}
