package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    public Post(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post() {

    }

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Post(String title) {
        this.title = title;
    }

    public Post(User user) {
        this.user = user;
    }

    public Post(String title, String content, Optional<User> byId) {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post get() {
        return null;
    }
}
