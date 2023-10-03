package com.quiz.AuthService.service;

import com.quiz.AuthService.model.UserCredentials;
import com.quiz.AuthService.repository.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> userCredentials = userCredentialsRepo.findByName(username);
        return userCredentials.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user name not found" + username));
    }
}
