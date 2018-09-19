package com.example.demo.service;


import com.example.demo.domain.dto.ProductDTO;

public interface ProductService {

    public ProductDTO getProduct(String name,Integer cost);

    public ProductDTO getProduct(String name);

    public ProductDTO getProduct(Integer id);

    public ProductDTO addProduct(ProductDTO product);
}
