package com.example.library.rest;

import com.example.library.book.Book;
import com.example.library.user.MyUser;
import com.example.library.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public String userPage(Model model) {
        model.addAttribute("content", "userPage");
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
        return "main";
    }
    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("userToAdd", new MyUser());
        model.addAttribute("showError", false);
        model.addAttribute("content", "register");
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
        return "main";
    }

    @PostMapping("/register")
    public String registerWrongUser(Model model, @ModelAttribute MyUser userToAdd) {
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
        model.addAttribute("userToAdd", new MyUser());
        if(userService.createUser(userToAdd)){
            userToAdd.setPassword(passwordEncoder.encode(userToAdd.getPassword()));
            userToAdd.setRole("USER");
            userService.createUser(userToAdd);
        }else{
            model.addAttribute("showError", true);
            model.addAttribute("content", "register");
            return "main";
        }
        model.addAttribute("content", "mainPage");
        return "main";
    }

    @GetMapping("/login")
    public String loginUser(Model model) {
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
        model.addAttribute("content", "login");
        model.addAttribute("test", authentication.getAuthorities());
        return "main";
    }

    @PostMapping("/login")
    public String loggedUser(Model model) {
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
        model.addAttribute("content", "mainPage");
        model.addAttribute("test", authentication.getAuthorities());
        return "main";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount(Model model) {
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
        model.addAttribute("content", "mainPage");
        return "main";
    }
}
