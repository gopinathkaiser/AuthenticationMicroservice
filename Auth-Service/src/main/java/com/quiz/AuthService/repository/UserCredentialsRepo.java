package com.quiz.AuthService.repository;

import com.quiz.AuthService.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialsRepo extends JpaRepository<UserCredentials, Integer> {
    Optional<UserCredentials> findByName(String username);

    UserCredentials findByEmail(String email);
}
