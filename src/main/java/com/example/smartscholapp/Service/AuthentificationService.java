package com.example.smartscholapp.Service;

import com.example.smartscholapp.Model.AuthentificationRequest;
import com.example.smartscholapp.Model.RegisterRequest;
import com.example.smartscholapp.Model.User;

public interface AuthentificationService {
    User register(RegisterRequest request);
    User authenticate(AuthentificationRequest request);
}
