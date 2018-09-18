package com.example.demo.repository;


import com.example.demo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    public Product findProductByNameAndCost(String name, int cost);
}
