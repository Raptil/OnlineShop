package com.example.onlineShop.domain.mapper;


import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.domain.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMap {

    public static Product toEntity(ProductDTO productDTO){

        if(productDTO==null) return null;

        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setName(productDTO.getName());
        product.setCost(productDTO.getCost());
        product.setCategory(productDTO.getCategory());

        return product;
    }

    public static ProductDTO toDTO(Product product){

        if(product==null) return null;

        ProductDTO productDTO=new ProductDTO();

        productDTO.setProductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setCost(product.getCost());
        productDTO.setCategory(product.getCategory());

        return productDTO;
    }

    public static List<Product> toEntity(List<ProductDTO> productDTOS){

        if(productDTOS==null) return null;

        List<Product> products=new ArrayList<>();
        for(ProductDTO productDTO:productDTOS)
            if(productDTO!=null) products.add(ProductMap.toEntity(productDTO));

        return products;
    }

    public static List<ProductDTO> toDTO(List<Product>products){

        if(products==null) return null;

        List<ProductDTO> productDTOS=new ArrayList<>();
        for(Product product:products)
            if(product!=null) productDTOS.add(ProductMap.toDTO(product));

        return productDTOS;
    }
}
