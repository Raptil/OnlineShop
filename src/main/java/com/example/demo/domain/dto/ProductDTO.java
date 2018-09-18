package com.example.demo.domain.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductDTO {

    private int productId;
    private String name;
    private int cost;
    private String category;
}
