package com.newstyle.shopping.repository;

import com.newstyle.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
    List<Product> findBySale(boolean sale);
    List<Product> findByNewArrival(boolean newArrival);
}

