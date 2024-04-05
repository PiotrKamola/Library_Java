package com.example.library.book;

import com.example.library.database.MySqlService;
import org.springframework.stereotype.Controller;

@Controller
public class GenreService {
    private final MySqlService mySqlService;

    public GenreService(MySqlService mySqlService) {
        this.mySqlService = mySqlService;
    }

    private void addGenre(Genre genre){
        mySqlService.addNewGenre(genre);
    }
}
