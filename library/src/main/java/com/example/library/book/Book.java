package com.example.library.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    private String name;
    private String author;
    private ArrayList<Genre> genres;
}
