package com.example.library.user;

import com.example.library.database.MySqlService;
import org.springframework.stereotype.Controller;

import java.util.Optional;

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

    public boolean createUser(MyUser myUser){
        try {
            mySqlService.addNewUser(myUser);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteUser(MyUser myUser){
        try {
            mySqlService.deleteUser(myUser);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Optional<MyUser> getUserByUsername(String username){
        return mySqlService.getUserByUsername(username);
    }
}
