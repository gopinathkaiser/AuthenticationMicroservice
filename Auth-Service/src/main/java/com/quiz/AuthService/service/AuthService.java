package com.quiz.AuthService.service;

import com.quiz.AuthService.Util.AuthUtil;
import com.quiz.AuthService.config.AuthConfig;
import com.quiz.AuthService.model.UserCredentials;
import com.quiz.AuthService.repository.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

    @Autowired
    private AuthUtil authUtil;

    public String saveUser(UserCredentials userCredentials){
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
         userCredentialsRepo.save(userCredentials);
         return "saved successfully";
    }

    public String generateToken(String username){
        System.out.println("call servce");
        return authUtil.generateToken(username);
    }

    public void validate(String username){
         authUtil.validateToken(username);
    }

}
