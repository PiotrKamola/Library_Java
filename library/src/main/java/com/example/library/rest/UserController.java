package com.example.library.rest;

import com.example.library.book.Book;
import com.example.library.user.MyUser;
import com.example.library.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String userPage() {
        return "userPage";
    }
    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("userToAdd", new MyUser());
        model.addAttribute("showError", false);
        return "register";
    }

    @PostMapping("/register")
    public String registerWrongUser(Model model, @ModelAttribute MyUser userToAdd) {
        model.addAttribute("userToAdd", new MyUser());
        if(userService.createUser(userToAdd)){
            userToAdd.setPassword(passwordEncoder.encode(userToAdd.getPassword()));
            userToAdd.setRole("USER");
            userService.createUser(userToAdd);
        }else{
            System.out.println("FALSE");
            model.addAttribute("showError", true);
            return "register";
        }
        return "main";
    }
}
