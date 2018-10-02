package com.example.onlineShop.domain.mapper;


import com.example.onlineShop.domain.dto.BasketDTO;
import com.example.onlineShop.domain.entity.Basket;

import java.util.ArrayList;
import java.util.List;


public class BasketMap {

    public static Basket toEntity(BasketDTO basketDTO) {
        if (basketDTO == null) return null;

        Basket basket = new Basket();
        basket.setBasketId(basketDTO.getBasketId());
        basket.setTotalCost(basketDTO.getTotalCost());
        basket.setUser(UserMap.toEntity(basketDTO.getUser()));
        basket.setProducts(ProductMap.toEntity(basketDTO.getProducts()));

        return basket;
    }

    public static BasketDTO toDTO(Basket basket) {

        if (basket == null) return null;

        BasketDTO basketDTO = new BasketDTO();
        basketDTO.setBasketId(basket.getBasketId());
        basketDTO.setTotalCost(basket.getTotalCost());
        basketDTO.setUser(UserMap.toDTO(basket.getUser()));
        basketDTO.setProducts(ProductMap.toDTO(basket.getProducts()));

        return basketDTO;
    }

    public static List<Basket> toEntity(List<BasketDTO> basketDTOS) {

        if (basketDTOS == null) return null;

        List<Basket> baskets = new ArrayList<>();
        for (BasketDTO basketDTO : basketDTOS)
            if (basketDTO != null) baskets.add(BasketMap.toEntity(basketDTO));

        return baskets;
    }

    public static List<BasketDTO> toDTO(List<Basket> baskets) {
        if (baskets == null) return null;

        List<BasketDTO> basketDTOS = new ArrayList<>();
        for (Basket basket : baskets)
            if (basket != null) basketDTOS.add(BasketMap.toDTO(basket));

        return basketDTOS;
    }
}
