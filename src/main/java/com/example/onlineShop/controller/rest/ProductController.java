package com.example.onlineShop.controller.rest;


import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO getProduct(@PathVariable("id") Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping(value = "/")
    public List<ProductDTO> getAllProducts() {
        return productService.getAll();
    }
}
