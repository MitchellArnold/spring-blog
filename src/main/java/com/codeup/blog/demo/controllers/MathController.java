package com.codeup.blog.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @RequestMapping(path = "/add/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String addTwoNumbers(@PathVariable int number, @PathVariable int number2) {
        return number + " plus " + (number2) + " is " + (number + number2) + "!";
    }

    @RequestMapping(path = "/subtract/{number}/from/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtractTwoNumbers(@PathVariable int number, @PathVariable int number2) {
        return number + " subtracted from " + number2 + " is " + (number2 - number) + "!";
    }

    @RequestMapping(path = "/multiply/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String mulitplyTwoNumbers(@PathVariable int number, @PathVariable int number2) {
        return number + " multiplied by " + number2 + " equals " + (number * number2) + "!";
    }

    @RequestMapping(path = "/divide/{number}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String divideTwoNumbers(@PathVariable double number, @PathVariable double number2) {
        if(number2 == 0){
            return number2 + " cannot be divided by zero.";
        }
        return number + " divided by " + number2 + " equals " + (number/number2) + "!";
    }

    /// When handling division, it's best to accept doubles in parameter so that partial values (decimals) may be accounted for.


}
