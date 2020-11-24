package com.codeup.blog;

import org.springframework.lang.UsesSunHttpServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

@Controller
 class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String Landing(){
        return "This is the landing page!";
    }
}

@Controller
 class MathController {
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public int addMap(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }
    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public int subtractMap(@PathVariable int x, @PathVariable int y) {
        return x - y;
    }
    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public int multiplyMap(@PathVariable int x, @PathVariable int y) {
        return x * y;
    }
    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public int divide(@PathVariable int x, @PathVariable int y) {
        return x / y;
    }
}

@Controller
class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPage(){
        return "posts index page";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postPage(@PathVariable String id){
        return "view an individual post";
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
