package com.example.tpcarnet.controller;

import com.example.tpcarnet.repository.ContactRepository;
import com.example.tpcarnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAuthController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/login")
    public String loginForm (Model model) {
        return "login";
    }
//    @GetMapping("login")
//    public String displayFormLogin(Model model) {
//        model.addAttribute("contacts", userRepository.findAll());
//        return "login";
//    }

    @GetMapping("profile")
    public String displayUserProfile (Model model) {
        return "/profile";
    }

}
