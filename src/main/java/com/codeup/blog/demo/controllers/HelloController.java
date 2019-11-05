package com.codeup.blog.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/howdy")
    public String sayHello(){
        return "<h1>hey</h1>";
    }

//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String sayHelloWithName(@PathVariable String name, Model viewModel){
//        viewModel.addAttribute("name", name);
//        System.out.println("name = " + name);
//        return "hey " + name + "!";
//    }

//    @GetMapping("/hello/{name}")
//    public String sayHello(@PathVariable String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello";
//    }

    @GetMapping("/hello/{name}")
    public String sayHelloWithName(@PathVariable String name, Model viewModel){
        viewModel.addAttribute("name", name);
        return "hello";
//hello is the name of the file
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }


    @GetMapping("/join")
    public String showJoinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "team") String cohort, Model vModel) {
        vModel.addAttribute("msg", "Welcome to " + cohort + "!");
        return "join";
    }


}
