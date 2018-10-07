package com.example.onlineShop.controller;

import com.example.onlineShop.domain.dto.BasketDTO;
import com.example.onlineShop.service.BasketService;
import com.example.onlineShop.service.ProductService;
import com.example.onlineShop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class BasketViewController {

    @Autowired
    BasketService basketService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    private static final Logger logger= LoggerFactory.getLogger(BasketViewController.class.getName());


    @PostMapping(value = "/addProductToBasket/{id}")
    public ModelAndView addProductToBasket(@PathVariable("id") Integer id, HttpSession httpSession) {
        if (httpSession.getAttribute("basket") == null) {
            BasketDTO basketDTO = new BasketDTO();
            httpSession.setAttribute("basket", basketDTO);
            logger.info("basket does not exist");

        }
        BasketDTO basket = (BasketDTO) httpSession.getAttribute("basket");
        basket = basketService.addProductToBasket(productService.getProduct(id), basket);
        httpSession.setAttribute("basket", basket);
        return new ModelAndView("redirect:/mainShop");

    }

    @GetMapping(value = "/onlineBasket")
    public ModelAndView getBasket(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("/onlineBasket");

        BasketDTO basketDTO = (BasketDTO) httpSession.getAttribute("basket");
        if (basketDTO == null) modelAndView.addObject("productsFromBasket", null);
        else modelAndView.addObject("productsFromBasket", basketDTO.getProducts());


        return modelAndView;
    }

    @PostMapping(value = "/onlineBasket/buy")
    public ModelAndView buyBasket(HttpSession session, HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("redirect:/mainShop");
        if (session.getAttribute("basket") != null) {
            BasketDTO basketDTO = (BasketDTO) session.getAttribute("basket");
            basketService.addBasket(basketDTO, userService.getUser(httpServletRequest.getRemoteUser()));

        }


        return modelAndView;
    }
}
