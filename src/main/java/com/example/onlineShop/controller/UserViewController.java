package com.example.onlineShop.controller;

import com.example.onlineShop.domain.dto.UserDTO;
import com.example.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserViewController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO userDTO = new UserDTO();
        modelAndView.addObject("user", userDTO);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public String registrationUser(@Valid@ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors())
            return "registration";
        if (userDTO != null) userService.registryUser(userDTO);

        return "redirect:/home";
    }

}
