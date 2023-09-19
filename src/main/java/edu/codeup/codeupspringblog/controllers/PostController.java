package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public String list(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts/list";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createSubmit(Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts")
    public String createPost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }
}