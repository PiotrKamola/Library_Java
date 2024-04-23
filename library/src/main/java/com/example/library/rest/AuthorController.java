package com.example.library.rest;

import com.example.library.book.Author;
import com.example.library.book.AuthorService;
import com.example.library.user.MyUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("loggedUser", authentication.getName());
        model.addAttribute("authorToAdd", new Author());
        model.addAttribute("content", "addAuthor");
        return "main";
    }

    @PostMapping("/addAuthor")
    public String addedNewAuthor(Model model, @ModelAttribute Author authorToAdd){
        authorService.addNewAuthor(authorToAdd);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("loggedUser", authentication.getName());
        model.addAttribute("content", "mainPage");
        return "main";
    }
}
