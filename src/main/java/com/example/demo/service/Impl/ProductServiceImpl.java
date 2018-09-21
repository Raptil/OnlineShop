package com.example.demo.service.Impl;

import com.example.demo.domain.dto.ProductDTO;
import com.example.demo.domain.mapper.ProductMap;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductDTO getProduct(String name,Integer cost){
        return ProductMap.toDTO(productRepository.findProductByNameAndCost(name,cost));
    }

    public ProductDTO getProduct(String name){
        return ProductMap.toDTO(productRepository.findProductByName(name));
    }

    public ProductDTO getProduct(Integer id){
        return ProductMap.toDTO(productRepository.findProductByProductId(id));
    }

    public ProductDTO addProduct(ProductDTO product){
        if (product==null) return null;
        return ProductMap.toDTO(productRepository.save(ProductMap.toEntity(product)));
    }
}
