package com.gym.gym_management.controller;

import com.gym.gym_management.entity.User;
import com.gym.gym_management.repository.UserRepository;
import com.gym.gym_management.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            response.put("message", "Username already exists!");
            return ResponseEntity.badRequest().body(response);
        }
        user.setRole("USER");
        userRepository.save(user);
        response.put("message", "User registered successfully!");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        Optional<User> found = userRepository.findByUsername(user.getUsername());

        if (found.isPresent() && found.get().getPassword().equals(user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            response.put("token", token);
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response);
        }

        response.put("message", "Invalid username or password!");
        return ResponseEntity.status(401).body(response);
    }
}