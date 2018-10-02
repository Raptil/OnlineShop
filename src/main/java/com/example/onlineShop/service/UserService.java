package com.example.onlineShop.service;


import com.example.onlineShop.domain.dto.RoleDTO;
import com.example.onlineShop.domain.dto.UserDTO;

import java.util.Set;

public interface UserService {

    public UserDTO getUser(Integer id);

    public UserDTO getUser(String email);

    public UserDTO registryUser(UserDTO user);

    public Set<RoleDTO> addRole(UserDTO userDTO, String roleName);


    public boolean isAdmin(UserDTO userDTO);

}
