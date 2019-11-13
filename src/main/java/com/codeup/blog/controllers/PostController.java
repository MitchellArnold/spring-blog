//package com.codeup.blog.demo.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class PostController {
//
//    @GetMapping("/posts")
//    @ResponseBody
//    public String postIndex() {
//        return "Howdy Earth!";
//    }
//
//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String singlePost(@PathVariable long id){
//        return "Yo! This is post numba " + id + "!";
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String viewCreatePost(){
//        return "Created yo post!";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String createNewPost(@RequestParam String title,@RequestParam String body){
//        System.out.println("title = " + title);
//        System.out.println("body = " + body);
//        return "Created Post!";
//    }
//
//
//}

package com.codeup.blog.controllers;

import com.codeup.blog.Post;
import com.codeup.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

//    // This will return JSON data
//    @GetMapping("/posts")
//    @ResponseBody
//    public List<Post> getAllPosts() {
//        return postDao.findAll();
//    }

    @GetMapping("/posts")
    public String getAllPosts(Model vm) {
        vm.addAttribute("retrievedPosts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam String author,
            @RequestParam String title,
            @RequestParam String content) {
        Post p = new Post(author, title, content);
        postDao.save(p);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public Post findPostById(@PathVariable Long id) {
        return postDao.getOne(id);
    }

}