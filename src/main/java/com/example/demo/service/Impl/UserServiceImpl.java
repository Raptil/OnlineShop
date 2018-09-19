package com.example.demo.service.Impl;

import com.example.demo.domain.dto.BasketDTO;
import com.example.demo.domain.dto.RoleDTO;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.mapper.UserMap;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleService roleService;

    public UserDTO getUser(Integer id){
        return UserMap.toDTO(userRepository.findUserByUserId(id));
    }

    public UserDTO getUser(String email){
        return UserMap.toDTO(userRepository.findUserByEmail(email));
    }

    public UserDTO registryUser(UserDTO user){
        if(user==null) return null;
        List<RoleDTO> roles=user.getRoles();
        roles.add(roleService.getRole("USER"));
        user.setRoles(roles);
        userRepository.save(UserMap.toEntity(user));
        return user;
    }

    public void addBasket(UserDTO user,BasketDTO basket){
        if(basket!=null && user!=null){
            List<BasketDTO> baskets=user.getBaskets();
            baskets.add(basket);
            user.setBaskets(baskets);
            userRepository.save(UserMap.toEntity(user));
        }
    }
}
