package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("")
    public String indexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String createPostForm(@PathVariable long id, Model model) {
        if (postDao.existsById(id)) {
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);
            return "posts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/create")
    public String createSubmit() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        System.out.println(title);
        System.out.println(content);
        postDao.save(new Post (title, content));
        return "redirect:/posts";
    }
}