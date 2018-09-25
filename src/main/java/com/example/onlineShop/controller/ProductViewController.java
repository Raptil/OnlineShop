package com.example.onlineShop.controller;

import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.service.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    ProductService productService;




    @GetMapping(value = "hello")
    public ModelAndView getProducts(){
        ModelAndView modelAndView= new ModelAndView();
        List<ProductDTO> productDTOS =productService.getAll();
        modelAndView.addObject("products",productDTOS);
        return modelAndView;
    }


}
