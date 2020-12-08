package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repository.PostRepository;
import com.codeup.blog.repository.UserRepository;
import com.codeup.blog.services.EmailService;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @GetMapping("/posts")
    public String indexPage(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPage(@PathVariable long id, Model model){
        Post postDb = postDao.getOne(id);
        model.addAttribute("post", postDb);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved) {
        User user = userDao.getOne(1L);
        postToBeSaved.setOwner(user);
        Post dbPost = postDao.save(postToBeSaved);
        return "redirect:/posts/" + dbPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "/posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post postToBeUpdated){
        User user = userDao.getOne(1L);
        postToBeUpdated.setOwner(user);
        postDao.save(postToBeUpdated);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";

    }

    @GetMapping("/rick-roll")
    public String rickRoll() {
        // redirecting to an absolute url
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
    @GetMapping("/redirect-me")
    public String redirect() {
        // a relative (to the base domain) redirect, usually you will use this
        // version
        // Will redirect the users to `/about`
        return "redirect:/about";
    }
}
