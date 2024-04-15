package com.example.library.database;

import com.example.library.book.Book;
import com.example.library.book.Genre;
import com.example.library.repository.BookRepository;
import com.example.library.repository.GenreRepository;
import com.example.library.repository.UserRepository;
import com.example.library.user.MyUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MySqlService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public MySqlService(UserRepository userRepository, BookRepository bookRepository, GenreRepository genreRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }
    public void addNewUser(MyUser myUser) {
        userRepository.save(myUser);
    }
    public void deleteUser(MyUser myUser) {
        userRepository.delete(myUser);
    }
    public void addNewBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }
    public void addNewGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public List<MyUser> getUsers() {
        return userRepository.findAll().stream()
                .toList();
    }
}
