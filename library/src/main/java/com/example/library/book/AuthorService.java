package com.example.library.book;

import com.example.library.database.MySqlService;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class AuthorService {
    private final MySqlService mySqlService;

    public AuthorService(MySqlService mySqlService) {
        this.mySqlService = mySqlService;
    }
    public void addBookToAuthor(Book book, Author author){
        author.getBookList().add(book);
    }
    public void addNewAuthor(Author author){
        mySqlService.addNewAuthor(author);
    }
    public ArrayList<Author> getAllAuthors(){
        return mySqlService.getAllAuthors();
    }
}
