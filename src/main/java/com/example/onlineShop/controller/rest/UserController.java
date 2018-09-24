package com.example.onlineShop.controller.rest;

import com.example.onlineShop.domain.dto.UserDTO;
import com.example.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public UserDTO getUser(@PathVariable("id")Integer id){
        return userService.getUser(id);
    }
}
