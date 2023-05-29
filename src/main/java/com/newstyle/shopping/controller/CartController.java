package com.newstyle.shopping.controller;

import com.newstyle.shopping.config.SessionManager;
import com.newstyle.shopping.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    
    private List<Product> cartItems = new ArrayList<>();
    
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Product product) {
        if (!SessionManager.getInstance().isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
        
        cartItems.add(product);
        return ResponseEntity.ok("Product added to cart.");
    }
    
    @GetMapping("/items")
    public ResponseEntity<List<Product>> getCartItems() {
        return ResponseEntity.ok(cartItems);
    }
    
    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart() {
        cartItems.clear();
        return ResponseEntity.ok("Cart cleared.");
    }
}