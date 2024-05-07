package com.example.library.repository;

import com.example.library.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    ArrayList<Book> findAll();
}
