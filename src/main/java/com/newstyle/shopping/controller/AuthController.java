package com.newstyle.shopping.controller;

import com.newstyle.shopping.model.User;
import com.newstyle.shopping.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.badRequest().body("{\"message\": \"Неверные имя пользователя или пароль\"}");
        }
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("message", "Вход выполнен успешно");
        return ResponseEntity.ok().body(jsonResponse.toString());
    }
    
}
