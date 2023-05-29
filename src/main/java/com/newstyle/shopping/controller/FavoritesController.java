package com.newstyle.shopping.controller;

import com.newstyle.shopping.config.SessionManager;
import com.newstyle.shopping.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {
    
    private List<Product> favoriteItems = new ArrayList<>();
    
    @PostMapping("/add")
    public ResponseEntity<String> addToFavorites(@RequestBody Product product) {
        if (!SessionManager.getInstance().isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        
        favoriteItems.add(product);
        return ResponseEntity.ok("Product added to favorites.");
    }
    
    @GetMapping("/items")
    public ResponseEntity<List<Product>> getFavoriteItems() {
        return ResponseEntity.ok(favoriteItems);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> clearFavorites(@PathVariable("id") int id) {
        favoriteItems.removeIf(item -> item.getId() == id);
        return ResponseEntity.ok("Favorites cleared.");
    }
}

