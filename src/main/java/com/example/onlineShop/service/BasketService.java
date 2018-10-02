package com.example.onlineShop.service;


import com.example.onlineShop.domain.dto.BasketDTO;
import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.domain.dto.UserDTO;

import java.util.List;


public interface BasketService {

    public BasketDTO getBasket(Integer id);

    public BasketDTO getBasket(UserDTO user);

    public BasketDTO addBasket(BasketDTO basketDTO, UserDTO user);

    public void addProductToBasket(ProductDTO productDTO, Integer basketId);

    public BasketDTO addProductToBasket(ProductDTO productDTO, BasketDTO basketDTO);

    public List<ProductDTO> getProductsFromBasket(Integer basketId);
}
