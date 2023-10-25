package com.quiz.AuthService.controller;

import com.quiz.AuthService.DTO.AuthRequest;
import com.quiz.AuthService.model.UserCredentials;
import com.quiz.AuthService.repository.UserCredentialsRepo;
import com.quiz.AuthService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.beans.Encoder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserCredentialsRepo userCredentialsRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public String saveUser(@RequestBody  UserCredentials userCredentials){

        return authService.saveUser(userCredentials);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest){
        System.out.println("call controller");
       UserCredentials userCredentials = userCredentialsRepo.findByEmail(authRequest.getEmail());
            if(passwordEncoder.matches(authRequest.getPassword(),userCredentials.getPassword())){
               return authService.generateToken(userCredentials.getEmail());

            }
            return "Password wrong";
    }

    @GetMapping("/validate")
    public void validate(@RequestParam String username){
        authService.validate(username);
    }
}
