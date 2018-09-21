package com.example.demo.domain.dto;




import lombok.Data;

import java.util.List;

@Data
public class BasketDTO {

    private int basketId;
    private int totalCost;
    private List<ProductDTO> products;
    private UserDTO user;


}
