package com.example.onlineShop.service;


import com.example.onlineShop.domain.dto.RoleDTO;


public interface RoleService {

    public RoleDTO getRole(String roleName);

    public RoleDTO getRole(Integer id);
}
