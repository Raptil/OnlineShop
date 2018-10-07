package com.example.onlineShop.service.Impl;

import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.domain.mapper.ProductMap;
import com.example.onlineShop.repository.ProductRepository;
import com.example.onlineShop.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private final static Logger logger = LoggerFactory.getLogger(ProductService.class.getName());

    public ProductDTO getProduct(String name, Integer cost) {
        return ProductMap.toDTO(productRepository.findProductByNameAndCost(name, cost));
    }

    public ProductDTO getProduct(String name) {
        return ProductMap.toDTO(productRepository.findProductByName(name));
    }

    public ProductDTO getProduct(Integer id) {
        return ProductMap.toDTO(productRepository.findProductByProductId(id));
    }

    public ProductDTO addProduct(ProductDTO product) {
        if (product == null) return null;
        return ProductMap.toDTO(productRepository.save(ProductMap.toEntity(product)));
    }

    public List<ProductDTO> getAll() {
        logger.info("get All products");
        return ProductMap.toDTO(productRepository.findAll());
    }

    public ProductDTO changeProduct(ProductDTO productDTO) {
        ProductDTO product = ProductMap.toDTO(productRepository.findProductByProductId(productDTO.getProductId()));
        product.setName(productDTO.getName());
        product.setCost(productDTO.getCost());
        product.setCategory(productDTO.getCategory());
        return ProductMap.toDTO(productRepository.save(ProductMap.toEntity(product)));
    }
}
