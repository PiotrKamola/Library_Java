package com.example.library.user;

import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = userRepository.findUserByUsername(username);
        if(user.isPresent()){
            var userObj = user.get();
            org.springframework.security.core.userdetails.User.builder();
            return User.builder()
                    .username(userObj.getUsername())
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();
        }else {
            throw new UsernameNotFoundException(username);
        }
    }

    private String[] getRoles(MyUser myUser){
        if(myUser.getRole() == null){
            return new String[]{"USER"};
        }
        return myUser.getRole().split(",");
    }
}
