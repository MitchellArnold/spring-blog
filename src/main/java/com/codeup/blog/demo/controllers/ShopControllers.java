package com.codeup.blog.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class ShopControllers {


    @GetMapping("/shop")
    @ResponseBody
    public String getShop(){
        return "<ul><h1>Shop Items</h1>" +
                "<li>" + "code here" + "</li>" +
                "</ul>";
    }






    public static void main(String[] args) {
        HashMap<String, Boolean> items = new HashMap<>();

        items.put("hammer", true);
        items.put("saw", true);
        items.put("drill", false);
        items.put("chain", false);
        items.put("screwdriver", true);
        items.put("corkscrew", true);

        System.out.println(items.isEmpty());
    }



}
