package com.example.onlineShop.service.Impl;


import com.example.onlineShop.domain.dto.RoleDTO;
import com.example.onlineShop.domain.mapper.RoleMap;
import com.example.onlineShop.repository.RoleRepository;
import com.example.onlineShop.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public RoleDTO getRole(String roleName){
        return RoleMap.toDTO(roleRepository.findRoleByRoleName(roleName));
    }

    public RoleDTO getRole(Integer id){
        return RoleMap.toDTO(roleRepository.findRoleByRoleId(id));
    }
}
