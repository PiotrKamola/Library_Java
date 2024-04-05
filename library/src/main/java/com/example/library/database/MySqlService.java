package com.example.library.database;

import com.example.library.book.Book;
import com.example.library.book.Genre;
import com.example.library.repository.BookRepository;
import com.example.library.repository.GenreRepository;
import com.example.library.repository.UserRepository;
import com.example.library.user.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void addNewUser(User user) {
        userRepository.save(user);
    }
    public void deleteUser(User user) {
        userRepository.delete(user);
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
}
