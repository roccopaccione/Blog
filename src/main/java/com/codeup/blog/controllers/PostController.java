package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repository.PostRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Post postDb = postDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("posts/create")
    public String viewCreatePostForm(){
        return "/posts/new";
    }

    @PostMapping("posts/create")
    public String submitCreatePost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post newPost = new Post(title, body);
        postDao.save(newPost);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "/posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Post editedPost = postDao.getOne(id);
        editedPost.setTitle(title);
        editedPost.setBody(body);
        postDao.save(editedPost);
        return "redirect:/posts/" + postDao.getId(id);
    }
}
