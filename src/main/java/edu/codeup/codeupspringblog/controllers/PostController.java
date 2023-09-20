package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.PostRepository;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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

//        System.out.println(title);
//        System.out.println(content);
        Optional<User> user = userDao.findById(2L);
        Post newPost = new Post(title, content);
        postDao.save(newPost);
        return "redirect:/posts";
//    }
    }

    @GetMapping("/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        if (postDao.existsById(id)) {
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);
            return "posts/edit";
        }
        return "redirect:/posts";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute Post post) {
        System.out.println(post.getTitle());
        User hardCoded = userDao.findById(1L).get();
        Post updatedPost = new Post(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                hardCoded
        );
        postDao.save(updatedPost);
        return "redirect:/posts";
    }
}