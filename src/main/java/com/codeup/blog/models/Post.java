package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @Column(nullable = false)
    private String author;

    @OneToOne
    private User owner;


    public Post() {}

    public Post (long id, String title, String body, User owner) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public User getOwner() {
        return owner;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

}
