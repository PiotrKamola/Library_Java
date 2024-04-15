package com.example.library.repository;

import com.example.library.user.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findUserByEmail(String email);
    Optional<MyUser> findUserByUsername(String username);
}
