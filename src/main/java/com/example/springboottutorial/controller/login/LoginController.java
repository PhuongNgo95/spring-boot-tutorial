package com.example.springboottutorial.controller.login;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController implements ErrorController {

    @GetMapping("/")
    public String getLogin(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/home")
    public String viewHomePage(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "home/home";
    }
}
