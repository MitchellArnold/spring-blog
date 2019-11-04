package com.codeup.blog.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postIndex() {
        return "Howdy Earth!";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String singlePost(@PathVariable String id){
        return "Yo! This is post numba" + id + "!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost(){
        return "Created yo post!";
    }

    @PostMapping(path = "/posts/create", consumes = "posts/create", produces = "posts/create")
    @ResponseBody
    public String createNewPost(@PathVariable String createNew){
        return "Created Post!";
    }


}
