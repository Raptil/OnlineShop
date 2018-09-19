package com.example.demo.service.Impl;


import com.example.demo.domain.dto.RoleDTO;
import com.example.demo.domain.mapper.RoleMap;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;


    public RoleDTO getRole(String roleName){
        return RoleMap.toDTO(roleRepository.findRoleByRoleName(roleName));
    }

    public RoleDTO getRole(Integer id){
        return RoleMap.toDTO(roleRepository.findRoleByRoleId(id));
    }
}
