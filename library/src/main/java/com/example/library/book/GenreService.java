package com.example.library.book;

import com.example.library.database.MySqlService;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class GenreService {
    private final MySqlService mySqlService;

    public GenreService(MySqlService mySqlService) {
        this.mySqlService = mySqlService;
    }

    public void addGenre(Genre genre){
        mySqlService.addNewGenre(genre);
    }

    public ArrayList<Genre> getAllGenres(){
        return mySqlService.getAllGenres();
    }
}
