package com.example.onlineShop.service;


import com.example.onlineShop.domain.dto.UserDTO;

public interface UserService {

    public UserDTO getUser(Integer id);

    public  UserDTO getUser(String email);

    public UserDTO registryUser(UserDTO user);

    //public void addBasket(UserDTO user,BasketDTO basket);

}
