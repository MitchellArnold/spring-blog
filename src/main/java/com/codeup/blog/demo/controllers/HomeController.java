package com.codeup.blog.demo.controllers;

import com.codeup.blog.demo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model viewModel){

//        ArrayList<Post> adsList = new ArrayList<Post>();
//
//        adsList.add(new Post(1,"first ad", "new"));
//        adsList.add(new Post(2,"second ad", "new"));
//        adsList.add(new Post(3,"third ad", "used"));
//
//        viewModel.addAttribute("ads", adsList);

        return "homepage";
    }

}
