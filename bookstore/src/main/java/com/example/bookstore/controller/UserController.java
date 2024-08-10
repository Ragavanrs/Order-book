package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bookstore.entity.User;
import com.example.bookstore.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/{username}")
    public ResponseEntity<?> getByUserName(@PathVariable("username") String username) {
        try {
        	System.out.println("username"+username);
            User user = userService.getByUserId(username);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            System.err.println("Error fetching user: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred while fetching the user.");
        }
    }

}
