package com.example.onlineShop.service.Impl;

import com.example.onlineShop.domain.dto.RoleDTO;
import com.example.onlineShop.domain.dto.UserDTO;
import com.example.onlineShop.domain.mapper.UserMap;
import com.example.onlineShop.repository.UserRepository;
import com.example.onlineShop.service.RoleService;
import com.example.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserDTO getUser(Integer id){
        return UserMap.toDTO(userRepository.findUserByUserId(id));
    }


    public UserDTO getUser(String email){
        return UserMap.toDTO(userRepository.findUserByEmail(email));
    }


    public UserDTO registryUser(UserDTO user){
        if(user==null) return null;
        Set<RoleDTO> roles;
        if(user.getRoles()!=null)
          roles=user.getRoles();
        else roles=new HashSet<>();
        user.setPassword(passwordEncoder.encode(user.getPassword()));;
        roles.add(roleService.getRole("USER"));
        user.setRoles(roles);

        userRepository.save(UserMap.toEntity(user));
        return user;
    }


  /*  public void addBasket(UserDTO user,BasketDTO basket){
        if(basket!=null && user!=null){
            List<BasketDTO> baskets=user.getBaskets();
            baskets.add(basket);
            user.setBaskets(baskets);
            userRepository.save(UserMap.toEntity(user));
        }
    }*/
}
