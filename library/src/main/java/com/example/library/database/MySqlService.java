package com.example.library.database;

import com.example.library.book.Author;
import com.example.library.book.Book;
import com.example.library.book.Genre;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.GenreRepository;
import com.example.library.repository.UserRepository;
import com.example.library.user.MyUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MySqlService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public MySqlService(UserRepository userRepository,
                        BookRepository bookRepository,
                        GenreRepository genreRepository,
                        AuthorRepository authorRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }
    public void addNewUser(MyUser myUser) {
        userRepository.save(myUser);
    }
    public void deleteUser(MyUser myUser) {
        userRepository.delete(myUser);
    }
    public Optional<MyUser> getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
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

    public void addNewAuthor(Author author){ authorRepository.save(author);}
    public ArrayList<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<MyUser> getUsers() {
        return userRepository.findAll().stream()
                .toList();
    }
}
