package com.example.demo.domain.mapper;


import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMap {

    public static User toEntity(UserDTO userDTO){

        if (userDTO==null) return null;

        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRoles(RoleMap.toEntity(userDTO.getRoles()));
        user.setBaskets(BasketMap.toEntity(userDTO.getBaskets()));

        return user;
    }

    public static UserDTO toDTO(User user){
        if(user==null) return null;

        UserDTO userDTO =new UserDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(RoleMap.toDTO(user.getRoles()));
        userDTO.setBaskets(BasketMap.toDTO(user.getBaskets()));

        return userDTO;
    }

    public static List<User> toEntity(List<UserDTO> userDTOS){
        if(userDTOS==null)return null;

        List<User> users=new ArrayList<>();
        for(UserDTO userDTO:userDTOS)
            if(userDTO!=null)users.add(UserMap.toEntity(userDTO));

        return users;
    }

    public static List<UserDTO> toDTO(List<User> users){
        if(users==null) return null;

        List<UserDTO> userDTOS=new ArrayList<>();
        for(User user:users)
            if(user!=null) userDTOS.add(UserMap.toDTO(user));

        return userDTOS;
    }
}
