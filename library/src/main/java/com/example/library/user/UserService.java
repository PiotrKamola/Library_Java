package com.example.library.user;

import com.example.library.database.MySqlService;
import org.springframework.stereotype.Controller;

@Controller
public class UserService {
    private final MySqlService mySqlService;

    public UserService(MySqlService mySqlService) {
        this.mySqlService = mySqlService;
    }

    public boolean login(){
        return true;
    }

    public boolean logout(){
        return true;
    }

    public boolean createUser(User user){
        try {
            mySqlService.addNewUser(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteUser(User user){
        try {
            mySqlService.deleteUser(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
