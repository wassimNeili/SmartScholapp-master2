package com.example.smartscholapp.serviceImpl;

import com.example.smartscholapp.Model.User;
import com.example.smartscholapp.DAO.UserRepository;
import com.example.smartscholapp.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User createUser(User user) {
        // Implement the logic to create a user
        // You can perform any additional validations or business logic here
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // Implement the logic to update a user
        // You can perform any additional validations or business logic here
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        // Implement the logic to delete a user by ID
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        // Implement the logic to retrieve a user by ID
        return userRepository.findById(userId).orElse(null);
    }

    // Implement the additional methods defined in the UserService interface
}

