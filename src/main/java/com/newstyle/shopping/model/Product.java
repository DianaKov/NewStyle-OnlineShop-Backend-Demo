package com.newstyle.shopping.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String category;
    
    private String description;
    
    @Column(nullable = false)
    private Double price;
    
    private String color;
    
    private String size;
    
    @Column(name = "image_path")
    private String imagePath;
    
    private boolean sale;
    
    @Column(name = "new_arrival")
    private boolean newArrival;
    
    public Product() {}
    
    public Product(Long id, String name, String category, String description, Double price, String color, String size, String imagePath, boolean sale, boolean newArrival) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.color = color;
        this.size = size;
        this.imagePath = imagePath;
        this.sale = sale;
        this.newArrival = newArrival;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public boolean isSale() {
        return sale;
    }
    
    public void setSale(boolean sale) {
        this.sale = sale;
    }
    
    public boolean isNewArrival() {
        return newArrival;
    }
    
    public void setNewArrival(boolean newArrival) {
        this.newArrival = newArrival;
    }

}

