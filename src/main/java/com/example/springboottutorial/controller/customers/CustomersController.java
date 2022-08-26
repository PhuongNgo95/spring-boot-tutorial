package com.example.springboottutorial.controller.customers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@CrossOrigin(origins = "*")
public class CustomersController {

    @GetMapping("/customers")
    public String customersHomePage(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("username", username);
        return "customers/customers";
    }
}
