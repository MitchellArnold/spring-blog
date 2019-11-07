package com.codeup.blog.demo.controllers;

import com.codeup.blog.demo.Ad;
import com.codeup.blog.demo.Post;
import com.codeup.blog.demo.PostDetails;
import com.codeup.blog.demo.repositories.JpaRepo;
import com.codeup.blog.demo.repositories.PostRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepo postDao;

    public PostController(PostRepo postDao) {
        this.postDao = postDao;
    }


//    @GetMapping("/posts")
//    @ResponseBody
//    public String postIndex() {
//        return "Howdy Earth!";
//    }

//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String singlePost(@PathVariable long id){
//        return "Yo! This is post numba " + id + "!";
//    }

    @GetMapping("/posts")
    public String index(Model vModel) {
        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @RequestParam(name="title") String newTitle, @RequestParam(name="description") String newDescription, Model vModel) {
        Post oldPost = postDao.getOne(id);
        oldPost.setTitle(newTitle);
        oldPost.setDescription(newDescription);
        postDao.save(oldPost);
        return "redirect:/posts";
    }


    @GetMapping("/posts/{id}/historyOfPost")

    public String getHistoryOfPost(@PathVariable long id, Model vModel) {

        Post post = postDao.getOne(id);

        vModel.addAttribute("post", post);

        return "posts/historyOfPost";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(@RequestParam String title, @RequestParam String body) {
        return "create a new post";
    }


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


//    @GetMapping("/posts/update")
//    public String returnTestView(Model viewModel) {
//        viewModel.addAttribute("postDetail", postDao.getOne(1L));
//        return "index";
//    }

//    @PostMapping("/pets/update/{id}")
//    public String updatePersonality(@PathVariable int id, @RequestParam String personality) {
//
//        // get the correct pet object to update
//        Post post = postDao.getOne(id);
//
//        // get the current pet details
////        PostDetails pd = ();
//
//        // update the pet details with the current details
//        pd.setPersonalityDescription(personality);
//        post.setDescription(pd);
//
//        // update the database record
//        postDao.save(post);
//
//        return "redirect:/posts";
//    }



}
