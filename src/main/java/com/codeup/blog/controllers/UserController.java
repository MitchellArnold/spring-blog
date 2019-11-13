package com.codeup.blog.controllers;

import com.codeup.blog.User;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.repositories.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private final UserRepository userDao;

    public UserController(UserRepository userDao) { this.userDao = userDao; }

//    public UserController(Users users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

//    public User(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }



    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }


//
//    @PostMapping("/sign-up")
//    public String saveUser(
//            @ModelAttribute User user,
//            @RequestParam String email,
//            @RequestParam String username,
//            @RequestParam String password
//    ) {
//        String hash = passwordEncoder.encode(password);
//        user.setPassword(hash);
//        user.setUsername(username);
//        user.setEmail(email);
//        user.save();
//        return "redirect:/login";
//    }

}
