package com.example.onlineShop.service;


import com.example.onlineShop.domain.dto.ProductDTO;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ProductService {

    public ProductDTO getProduct(String name, Integer cost);

    public ProductDTO getProduct(String name);

    public ProductDTO getProduct(Integer id);

    public ProductDTO addProduct(ProductDTO product);

    @Secured(value = {"ROLE_ADMIN"})
    public ProductDTO changeProduct(ProductDTO productDTO);

    public List<ProductDTO> getAll();
}
