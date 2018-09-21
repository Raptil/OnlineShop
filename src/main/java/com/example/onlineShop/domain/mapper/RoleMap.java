package com.example.onlineShop.domain.mapper;


import com.example.onlineShop.domain.dto.RoleDTO;
import com.example.onlineShop.domain.entity.Role;

import java.util.HashSet;
import java.util.Set;


public class RoleMap {

    public static Role toEntity(RoleDTO roleDTO){
        if( roleDTO== null) return null;

        Role role =new Role();
        role.setRoleId(roleDTO.getRoleId());
        role.setRoleName(roleDTO.getRoleName());

        return role;
    }

    public static RoleDTO toDTO(Role role){
        if (role==null) return null;

        RoleDTO roleDTO=new RoleDTO();

        roleDTO.setRoleId(role.getRoleId());
        roleDTO.setRoleName(role.getRoleName());

        return roleDTO;
    }

    public static Set<Role> toEntity(Set<RoleDTO> roleDTOS){
        if (roleDTOS==null) return null;
        Set<Role> roles =new HashSet<>();
        for(RoleDTO roleDTO:roleDTOS)
            if(roleDTO!=null) roles.add(RoleMap.toEntity(roleDTO));
       return roles;
    }

    public static Set<RoleDTO> toDTO(Set<Role> roles){
        if(roles==null) return null;

        Set<RoleDTO> roleDTOS=new HashSet<>();

        for (Role role:roles)
            if(role==null) roleDTOS.add(RoleMap.toDTO(role));

        return roleDTOS;
    }
}
