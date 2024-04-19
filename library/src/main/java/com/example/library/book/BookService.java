package com.example.library.book;

import com.example.library.database.MySqlService;
import com.example.library.user.MyUser;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    private final MySqlService mySqlService;
    private final AuthorService authorService;

    public BookService(MySqlService mySqlService, AuthorService authorService) {
        this.mySqlService = mySqlService;
        this.authorService = authorService;
    }

    public void addBook(Book book){
        mySqlService.addNewBook(book);
        authorService.addBookToAuthor(book, book.getAuthor());
    }

    public void setBookForSale(Book book){
        book.setForSale(true);
    }

    public boolean sellBook(Book book, MyUser myUser){
        if(book.isForSale()){
            if(book.isUsed()){
                if(book.isDamaged()){
                    book.setPrice(book.getPrice() / 2);
                }else {
                    book.setPrice(book.getPrice() / 1.5);
                }
            }
            mySqlService.deleteBook(book);
            return true;
        }else{
            return false;
        }
    }
}
