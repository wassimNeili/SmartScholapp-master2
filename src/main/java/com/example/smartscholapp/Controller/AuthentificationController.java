package com.example.smartscholapp.Controller;

import com.example.smartscholapp.Model.AuthentificationRequest;
import com.example.smartscholapp.Model.RegisterRequest;
import com.example.smartscholapp.Model.User;
import com.example.smartscholapp.serviceImpl.AuthentificationServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
@CrossOrigin(origins = "*")
public class AuthentificationController  {

    private final AuthentificationServiceImp authService;

    public AuthentificationController(AuthentificationServiceImp authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest request) {
        User user = authService.register(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody AuthentificationRequest request) {
        User user = authService.authenticate(request);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}