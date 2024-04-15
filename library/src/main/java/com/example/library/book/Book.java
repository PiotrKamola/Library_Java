package com.example.library.book;

import com.example.library.user.MyUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "BOOKS", schema = "library")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
//    @ManyToOne(fetch = FetchType.EAGER)
//    private MyUser whichUserRenting;
    private int releaseYear;
    @ManyToMany
    @JoinTable(
            name = "bookGenres",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "genreId"))
    private ArrayList<Genre> genres;
    private boolean isForSale;
    private boolean isUsed;
    private boolean isDamaged;
    private double price;
    private boolean isRented;
}
