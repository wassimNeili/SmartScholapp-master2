package com.example.smartscholapp.Service;

import com.example.smartscholapp.Model.User;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    // Define additional methods for user-related operations if needed
}

