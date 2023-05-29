package com.newstyle.shopping.controller;

import com.newstyle.shopping.model.Product;
import com.newstyle.shopping.repository.ProductRepository;
import com.newstyle.shopping.servise.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam("name") String name) {
        return productService.searchProducts(name);
    }
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @GetMapping(params = "category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productRepository.findByCategory(category);
    }
    
    @GetMapping(params = "sale")
    public List<Product> getProductsBySale(@RequestParam boolean sale) {
        return productRepository.findBySale(sale);
    }
    
    @GetMapping(params = "new_arrival")
    public List<Product> getProductsByNewArrival(@RequestParam boolean newArrival) {
        return productRepository.findByNewArrival(newArrival);
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }
    
    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
    
    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}

