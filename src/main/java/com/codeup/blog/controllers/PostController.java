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
import com.codeup.blog.User;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

//    // This will return JSON data
//    @GetMapping("/posts")
//    @ResponseBody
//    public List<Post> getAllPosts() {
//        return postDao.findAll();
//    }

    // View posts
    @GetMapping("/posts")
    public String getAllPosts(Model vModel) {
        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    // View post by id
    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model vModel) {
        Post postToView = postDao.getOne(id);
        vModel.addAttribute("post", postToView);
        vModel.addAttribute("titleMsg", "Post - " + postToView.getTitle());
        return "posts/show";
    }

    // View create form
    @GetMapping("/posts/create")
    public String getCreatePostForm(Model vModel) {
        vModel.addAttribute("post", new Post());

        return "posts/create";
    }


    // Submit create form
    @PostMapping("/posts/create")
    public String submitCreatePostForm(@ModelAttribute Post postFromForm) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postFromForm.setUser(userDao.findByUsername(loggedInUser.getUsername()));
        postDao.save(postFromForm);
        long newPostId = postFromForm.getId();
        emailService.prepareAndSend(
                postFromForm,
                "New Post on Spring in November",
                "Your post '" + postFromForm.getTitle() + "' is now viewable on Spring in November."
        );
        return "redirect:/posts/" + newPostId;
    }

    // Delete post form
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable("id") long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    //  View edit post form
    @GetMapping("/posts/{id}/edit")
    public String getEditPortForm(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    // Submit edit post form
    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post editedPost) {
        editedPost.setUser(userDao.getOne(3L));
        postDao.save(editedPost);
        return "redirect:/posts/" + editedPost.getId();
    }

//    @PostMapping("/posts/create")
//    public String createPost(
//            @RequestParam String author,
//            @RequestParam String title,
//            @RequestParam String content) {
//        Post p = new Post(author, title, content);
//        postDao.save(p);
//        return "redirect:/posts";
//    }

//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public Post findPostById(@PathVariable Long id) {
//        return postDao.getOne(id);
//    }

}