package com.example.demo.repository;


import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findByNameAndCost(String name, int cost);
}
