package com.adeng1024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam("password") String password, @RequestParam("username") String username, Model model, HttpSession session) {
        if (username.equals("adeng1024") && !password.isEmpty()) {
            session.setAttribute("user", username);
            return "redirect:dashboard";
        }
        session.removeAttribute("user");
        model.addAttribute("msg", "账号或者密码错误");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @GetMapping("/signOut")
    public String signOut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
