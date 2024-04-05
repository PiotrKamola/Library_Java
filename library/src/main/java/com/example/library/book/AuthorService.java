package com.example.library.book;

import org.springframework.stereotype.Controller;

@Controller
public class AuthorService {
    public void addBookToAuthor(Book book, Author author){
        author.getBookList().add(book);
    }
}
