package com.example.library.repository;

import com.example.library.book.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    ArrayList<Genre> findAll();
}
