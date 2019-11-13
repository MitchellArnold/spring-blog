package com.codeup.blog.controllers;

import com.codeup.blog.User;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.repositories.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private final UserRepository userDao;

    public AuthenticationController(UserRepository userDao) { this.userDao = userDao; }


    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }


}
