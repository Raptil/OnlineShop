package com.example.demo.service;


import com.example.demo.domain.dto.BasketDTO;
import com.example.demo.domain.dto.UserDTO;

public interface UserService {

    public UserDTO getUser(Integer id);

    public  UserDTO getUser(String email);

    public UserDTO registryUser(UserDTO user);

    public void addBasket(UserDTO user,BasketDTO basket);

}
