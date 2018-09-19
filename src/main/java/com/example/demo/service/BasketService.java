package com.example.demo.service;


import com.example.demo.domain.dto.BasketDTO;
import com.example.demo.domain.dto.ProductDTO;
import com.example.demo.domain.dto.UserDTO;

import java.util.List;


public interface BasketService {

    public BasketDTO getBasket(Integer id);

    public BasketDTO getBasket(UserDTO user);

    public BasketDTO addBasket(UserDTO user);

    public void addProductToBasket(ProductDTO productDTO,Integer basketId);
}
