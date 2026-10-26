package com.example.ExpenseTracker.service;

import com.example.ExpenseTracker.model.LoginRequest;
import com.example.ExpenseTracker.model.User;
import com.example.ExpenseTracker.repo.UserRepo;
import com.example.ExpenseTracker.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
private UserRepo userRepo;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);

public User registerUser(User user){
    if(userRepo.findByEmail(user.getEmail()) != null){
        throw new RuntimeException("Email registered");
    }
    user.setPassword(encoder.encode(user.getPassword()));
    return userRepo.save(user);
}


    public String verify(LoginRequest loginRequest) {
        Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
if (authentication.isAuthenticated()) return jwtService.generateToken(loginRequest.getEmail());
return "fail";
    }
}
