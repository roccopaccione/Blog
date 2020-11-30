package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
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
    @GetMapping("/posts")
    public String indexPage(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Post 1", "Some cool stuff 1."));
        posts.add(new Post("Post 2", "Some cool stuff 2."));
        posts.add(new Post("Post 3", "Some cool stuff 3."));

        model.addAttribute("posts", posts);
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
