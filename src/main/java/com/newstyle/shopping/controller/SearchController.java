package com.newstyle.shopping.controller;

import com.newstyle.shopping.model.Product;
import com.newstyle.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    
    private final ProductRepository productRepository;
    
    @Autowired
    public SearchController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @GetMapping("/search")
    public List<Product> search(@RequestParam("category") String category) {
        List<Product> results = productRepository.findByCategory(category);
        return results;
    }
}