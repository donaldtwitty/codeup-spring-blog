package edu.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @GetMapping("/posts")
    public String getPostsIndexPage() {
        return "This is the posts index page.";
    }

    @GetMapping("posts/{id}")
    public String viewPost(@PathVariable("id") String id) {
        return "This is the page for viewing post with id " + id;
    }

    @GetMapping("posts/create")
    public String getPostCreateForm() {
        return "View form for creating a post.";
    }

    @PostMapping("posts/create")
    public String createPost() {
        return "This is a new post.";
    }
}
