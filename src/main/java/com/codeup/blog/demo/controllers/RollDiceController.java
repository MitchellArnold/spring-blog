package com.codeup.blog.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String guessRoll(@PathVariable int number, Model viewModel){
        viewModel.addAttribute("num", number);
        return "rolldice";
    }

    @PostMapping("/roll-dice")
    public String guessRoll(@RequestParam(name = "roll") String dice, Model vModel) {
        vModel.addAttribute("msg", "You guessed " + dice + "!");
        return "rolldice";
    }

//    @GetMapping("/hello/{name}")
//    public String sayHelloWithName(@PathVariable String name, Model viewModel){
//        viewModel.addAttribute("name", name);
//        return "hello";
////hello is the name of the file
//    }

//
//    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
//    @ResponseBody
//    public String addOne(@PathVariable int number) {
//        return number + " plus one is " + (number + 1) + "!";
//    }
//
//
//    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)

}
