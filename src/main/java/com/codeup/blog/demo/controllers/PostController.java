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
    public String singlePost(@PathVariable long id){
        return "Yo! This is post numba " + id + "!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost(){
        return "Created yo post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(@RequestParam String title,@RequestParam String body){
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        return "Created Post!";
    }


}
