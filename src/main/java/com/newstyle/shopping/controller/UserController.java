package com.newstyle.shopping.controller;

import com.newstyle.shopping.model.User;
import com.newstyle.shopping.repository.UserRepository;
import org.json.JSONObject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("{\"message\": \"Email уже зарегистрирован\"}");
        }
        userRepository.save(user);
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("message", "Пользователь успешно зарегистрирован");
        return ResponseEntity.ok().body(jsonResponse.toString());
    }
    
    
}
