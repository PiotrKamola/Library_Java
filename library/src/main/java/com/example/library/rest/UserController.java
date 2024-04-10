package com.example.library.rest;

import com.example.library.user.User;
import com.example.library.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String menu(Model model) {
        model.addAttribute("userToAdd", new User());
        model.addAttribute("showError", false);
        return "register";
    }

    @PostMapping("/register")
    public String registerWrongUser(Model model, @ModelAttribute User userToAdd) {
        model.addAttribute("userToAdd", new User());
        if(userService.createUser(userToAdd)){
            System.out.println("TRUE");
            userService.createUser(userToAdd);
        }else{
            System.out.println("FALSE");
            model.addAttribute("showError", true);
            return "register";
        }
        return "main";
    }
}
