package com.example.demo.domain.mapper;


import com.example.demo.domain.dto.RoleDTO;
import com.example.demo.domain.entity.Role;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Role> toEntity(List<RoleDTO> roleDTOS){
        if (roleDTOS==null) return null;
        List<Role> roles =new ArrayList<>();
        for(RoleDTO roleDTO:roleDTOS)
            if(roleDTO!=null) roles.add(RoleMap.toEntity(roleDTO));
       return roles;
    }

    public static List<RoleDTO> toDTO(List<Role> roles){
        if(roles==null) return null;

        List<RoleDTO> roleDTOS=new ArrayList<>();

        for (Role role:roles)
            if(role!=null) roleDTOS.add(RoleMap.toDTO(role));

        return roleDTOS;
    }
}
