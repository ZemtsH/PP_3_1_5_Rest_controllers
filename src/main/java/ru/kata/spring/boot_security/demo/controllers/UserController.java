package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/")
    public String show(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user_one", user);
        return "user/user";
    }
}