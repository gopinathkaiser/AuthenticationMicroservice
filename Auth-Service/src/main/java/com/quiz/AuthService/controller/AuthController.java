package com.quiz.AuthService.controller;

import com.quiz.AuthService.DTO.AuthRequest;
import com.quiz.AuthService.model.UserCredentials;
import com.quiz.AuthService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/add")
    public String saveUser(@RequestBody  UserCredentials userCredentials){

        return authService.saveUser(userCredentials);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest){
        System.out.println("call controller");
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return authService.generateToken(authRequest.getUsername());
        }else{
            throw new RuntimeException("Invalid access");
        }
    }

    @GetMapping("/validate")
    public void validate(@RequestParam String username){
        authService.validate(username);
    }
}
