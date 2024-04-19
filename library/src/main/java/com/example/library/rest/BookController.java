package com.example.library.rest;

import com.example.library.book.Author;
import com.example.library.book.AuthorService;
import com.example.library.book.Book;
import com.example.library.book.BookService;
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

    public BookController(BookService bookService, AuthorService authorService){
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/addBook")
    public String addBook(Model model){
        model.addAttribute("bookToAdd", new Book());
        model.addAttribute("allAuthors", authorService.getAllAuthors());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addedNewBook(Model model, @ModelAttribute Book bookToAdd){
        model.addAttribute("bookToAdd", new Book());
        bookService.addBook(bookToAdd);
        return "main";
    }
}
