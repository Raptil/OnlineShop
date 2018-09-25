package com.example.onlineShop.service.Impl;

import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.domain.mapper.ProductMap;
import com.example.onlineShop.repository.ProductRepository;
import com.example.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

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
    @ModelAttribute("products")
    public List<ProductDTO> getAll(){
        return ProductMap.toDTO(productRepository.findAll());
    }
}
