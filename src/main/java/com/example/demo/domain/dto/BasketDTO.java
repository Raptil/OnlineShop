package com.example.demo.domain.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BasketDTO {

    private int basketId;
    private int totalCost;
    private List<ProductDTO> products;
    private UserDTO user;
}
