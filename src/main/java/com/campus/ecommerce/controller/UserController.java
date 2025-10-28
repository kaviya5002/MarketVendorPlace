package com.campus.ecommerce.controller;

import com.campus.ecommerce.User;
import com.campus.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*") // allows frontend to access this API
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Register a new user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Login (simple version)
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User found = userRepository.findByEmail(user.getEmail());
        if (found != null && found.getPassword().equals(user.getPassword())) {
            return "✅ Login successful for " + found.getName();
        } else {
            return "❌ Invalid email or password";
        }
    }
}
