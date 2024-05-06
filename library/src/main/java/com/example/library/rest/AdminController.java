package com.example.library.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("")
    public String menu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("loggedUser", authentication.getName());
        for(GrantedAuthority s: authentication.getAuthorities()){
            if(s.toString().equals("ROLE_USER")){
                model.addAttribute("isUser", "true");
            }
            if(s.toString().equals("ROLE_ADMIN")){
                model.addAttribute("isAdmin", "true");
            }
        }
        model.addAttribute("content", "adminPage");
        return "main";
    }
}
