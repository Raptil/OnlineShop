package com.example.onlineShop.repository;


import com.example.onlineShop.domain.entity.Basket;
import com.example.onlineShop.domain.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasketRepositoryTest {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void addBasketWithProductsAndUser() {
        Basket basket = new Basket();
        basket.setUser(userRepository.findUserByEmail("userEmail"));
        List<Product> products = new ArrayList<Product>();
        products.add(productRepository.findProductByNameAndCost("phone", 10000));
        products.add(productRepository.findProductByNameAndCost("pen", 10));
        basket.setProducts(products);
        basket.setTotalCost(products.get(0).getCost() + products.get(1).getCost());
        basketRepository.save(basket);


    }

}
