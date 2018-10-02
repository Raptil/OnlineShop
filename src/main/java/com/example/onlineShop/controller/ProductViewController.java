package com.example.onlineShop.controller;

import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.domain.dto.UserDTO;
import com.example.onlineShop.service.ProductService;
import com.example.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


    @GetMapping(value = "/mainShop")
    public ModelAndView getProducts(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("/mainShop");
        List<ProductDTO> productDTOS = productService.getAll();
        modelAndView.addObject("products", productDTOS);
        UserDTO userDTO = userService.getUser(httpServletRequest.getRemoteUser());
        String role = "ROLE_USER";
        if (userService.isAdmin(userDTO))
            role = "ROLE_ADMIN";
        modelAndView.addObject("role", role);
        return modelAndView;
    }

    @GetMapping(value = "/product/{id}/edit")
    public ModelAndView editProduct(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        ProductDTO productDTO = productService.getProduct(id);
        modelAndView.addObject("product", productDTO);
        return modelAndView;
    }


    @PostMapping(value = "/product/{id}/edit")
    public ModelAndView editProduct(@ModelAttribute("product") ProductDTO productDTO, @PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/mainShop");
        productDTO.setProductId(id);
        productService.changeProduct(productDTO);
        return modelAndView;
    }

    @GetMapping(value = "/product/add")
    public ModelAndView addProduct(){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        ProductDTO productDTO=new ProductDTO();
        modelAndView.addObject("product",productDTO);
        return modelAndView;
    }
    @PostMapping(value = "/product/add")
    public ModelAndView addProduct(@ModelAttribute("product")ProductDTO productDTO){
        ModelAndView modelAndView = new ModelAndView("redirect:/mainShop");
        productService.addProduct(productDTO);
        return modelAndView;
    }


}
