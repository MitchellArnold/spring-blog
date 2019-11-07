package com.codeup.blog.demo.controllers;

import com.codeup.blog.demo.Ad;
import com.codeup.blog.demo.Post;
import com.codeup.blog.demo.PostDetails;
import com.codeup.blog.demo.repositories.JpaRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final JpaRepo postDao;

    public PostController(JpaRepo postDao) {
        this.postDao = postDao;
    }


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


    @GetMapping("/posts/update")
    public String returnTestView(Model viewModel) {
        viewModel.addAttribute("postDetail", postDao.getOne(1L));
        return "index";
    }

    @PostMapping("/pets/update/{id}")
    public String updatePersonality(@PathVariable int id, @RequestParam String personality) {

        // get the correct pet object to update
        Ad post = postDao.getOne((long) id);

        // get the current pet details
        PostDetails pd = ();

        // update the pet details with the current details
        pd.setPersonalityDescription(personality);
        post.setDescription(pd);

        // update the database record
        postDao.save(post);

        return "redirect:/posts";
    }



}
