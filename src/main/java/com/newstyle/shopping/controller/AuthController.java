package com.newstyle.shopping.controller;

import com.newstyle.shopping.config.SessionManager;
import com.newstyle.shopping.model.User;
import com.newstyle.shopping.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        jsonResponse.put("isAuthenticated", true);
        jsonResponse.put("email", foundUser.getEmail());
        SessionManager.getInstance().setAuthenticated(true);
        return ResponseEntity.ok().body(jsonResponse.toString());
    }
    
    @GetMapping("/client/{email}")
    public ResponseEntity<?> getClientData(@PathVariable String email) {
        User foundUser = userRepository.findByEmail(email);
        if (foundUser == null) {
            return ResponseEntity.badRequest().body("{\"message\": \"Пользователь не найден\"}");
        }
        
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("email", foundUser.getEmail());
        
        return ResponseEntity.ok().body(jsonResponse.toString());
    }
    
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        SessionManager.getInstance().setAuthenticated(false);
        return ResponseEntity.ok("Logged out successfully.");
    }
    
}
