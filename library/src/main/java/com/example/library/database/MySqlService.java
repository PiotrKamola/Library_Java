package com.example.library.database;

import com.example.library.repository.UserRepository;
import com.example.library.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MySqlService {
    private final UserRepository userRepository;

    @Autowired
    public MySqlService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
