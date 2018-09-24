package com.example.onlineShop.controller.rest;

import com.example.onlineShop.domain.dto.BasketDTO;
import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/basket")
public class BasketController {

    @Autowired
    private  BasketService basketService;

    @GetMapping(value = "/{id}")
    public BasketDTO getBasket(@PathVariable("id")Integer id){
        return basketService.getBasket(id);
    }

    @GetMapping(value = "/{id}/product")
    public List<ProductDTO> getProductsFromBasket(@PathVariable("id")Integer id){
        return basketService.getProductsFromBasket(id);
    }
}
