package com.example.onlineShop.controller;

import com.example.onlineShop.domain.dto.ProductDTO;
import com.example.onlineShop.domain.dto.UserDTO;
import com.example.onlineShop.service.ProductService;
import com.example.onlineShop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


private final static Logger logger = LoggerFactory.getLogger(ProductViewController.class.getName());

    @GetMapping(value = "/mainShop")
    public ModelAndView getProducts(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("/mainShop");
        List<ProductDTO> productDTOS = productService.getAll();
        modelAndView.addObject("products", productDTOS);
        UserDTO userDTO = userService.getUser(httpServletRequest.getRemoteUser());
        String role = "ROLE_USER";
        if (userService.isAdmin(userDTO)){
            role = "ROLE_ADMIN";
            logger.info("user with role ROLE_ADMIN");
        }
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
    public ModelAndView editProduct(@Valid@ModelAttribute("product") ProductDTO productDTO,BindingResult bindingResult, @PathVariable("id") Integer id) {
        ModelAndView modelAndView;
        if(bindingResult.hasErrors()){
            modelAndView=new ModelAndView("/product/{id}/edit");
            return modelAndView;
        }
        modelAndView = new ModelAndView("redirect:/mainShop");
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
    public ModelAndView addProduct(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult){
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()){
            modelAndView=new ModelAndView("addProduct");
            logger.info("add product with errors");
            return modelAndView;
        }
        logger.info("add product without errors");
         modelAndView = new ModelAndView("redirect:/mainShop");
        productService.addProduct(productDTO);
        return modelAndView;
    }


}
