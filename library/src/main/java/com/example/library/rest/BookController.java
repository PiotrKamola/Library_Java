package com.example.library.rest;

import com.example.library.book.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("book")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookController(BookService bookService, AuthorService authorService, GenreService genreService){
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping("/addBook")
    public String getBookToAddData(Model model){
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
        model.addAttribute("bookToAdd", new Book());
        model.addAttribute("allAuthors", authorService.getAllAuthors());
        model.addAttribute("allGenres", genreService.getAllGenres());
        model.addAttribute("content", "addBook");
        return "main";
    }

    @PostMapping("/addBook")
    public String addNewBook(Model model, @ModelAttribute Book bookToAdd){
        model.addAttribute("bookToAdd", new Book());
        bookService.addBook(bookToAdd);
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

    @GetMapping("/addGenre")
    public String getGenreToAddData(Model model){
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
        model.addAttribute("genreToAdd", new Genre());
        model.addAttribute("content", "addGenre");
        return "main";
    }

    @PostMapping("/addGenre")
    public String addNewGenre(Model model, @ModelAttribute Genre genreToAdd){
        model.addAttribute("genreToAdd", new Genre());
        genreService.addGenre(genreToAdd);
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

    @GetMapping("/allBooks")
    public String getallBooks(Model model){
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
        model.addAttribute("allBooks", bookService.getAllBooks());
        model.addAttribute("content", "allBooks");
        return "main";
    }
}
