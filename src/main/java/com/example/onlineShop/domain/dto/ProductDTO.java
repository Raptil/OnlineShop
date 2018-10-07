package com.example.onlineShop.domain.dto;


import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ProductDTO {

    private int productId;

    @Size(min = 3, message = "name must be more 2 symbols")
    private String name;
    private int cost;
    @Size(min = 3, message = "category must be more 2 symbols")
    private String category;
}
