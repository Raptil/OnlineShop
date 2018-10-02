package com.example.onlineShop.repository;


import com.example.onlineShop.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product findProductByNameAndCost(String name, int cost);

    public Product findProductByName(String name);

    public Product findProductByProductId(Integer id);

}
