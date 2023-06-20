package com.example.smartscholapp.serviceImpl;

import com.example.smartscholapp.DAO.UserRepository;
import com.example.smartscholapp.Model.AuthentificationRequest;
import com.example.smartscholapp.Model.RegisterRequest;
import com.example.smartscholapp.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImp {

    private final UserRepository repository;


    public User register(RegisterRequest request) {
        var user = User.builder()
                .nom(request.getNom())

                .email(request.getEmail())
                .password((request.getPassword()))
                .role(request.getRole())
                .expertise(request.getExpertise())
                .build();
        var savedUser = repository.save(user);
        return savedUser;
    }

    public User authenticate(AuthentificationRequest request) {
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(); // throws exception if email is not found
        if (user.getPassword().equals(request.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Incorrect email or password");
        }
    }

}