package com.example.demo.service;


import com.example.demo.domain.dto.RoleDTO;


public interface RoleService {

    public RoleDTO getRole(String roleName);

    public RoleDTO getRole(Integer id);
}
