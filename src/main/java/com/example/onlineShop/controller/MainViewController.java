package com.example.onlineShop.controller;

import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainViewController {

    @Autowired
    ProductService productService;





    @GetMapping(value = {"/","/home"})
    public ModelAndView getProducts(){
        ModelAndView modelAndView= new ModelAndView("/home");
        List<ProductDTO> productDTOS =productService.getAll();
        modelAndView.addObject("products",productDTOS);
        return modelAndView;
    }
}
