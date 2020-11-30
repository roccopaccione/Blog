package com.codeup.blog.controllers;

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

