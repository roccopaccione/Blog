package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repository.PostRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String indexPage(Model model){
        model.addAttribute("posts", postDao);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String showPage(@PathVariable long id, Model model){
        Post post = new Post("Post" + id, "Some cool new stuff" + id + ".");
        model.addAttribute("post", post);
        return "posts/show";
    }
    @GetMapping("posts/create")
    @ResponseBody
    public String viewFormPage(){
        return "view the form for creating a post";
    }
    @PostMapping("posts/create")
    @ResponseBody
    public String createPostPage(){
        return "create a new post";
    }
}
