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

import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserDTO getUser(Integer id) {
        return UserMap.toDTO(userRepository.findUserByUserId(id));
    }


    public UserDTO getUser(String email) {
        return UserMap.toDTO(userRepository.findUserByEmail(email));
    }


    public UserDTO registryUser(UserDTO user) {
        if (user == null) return null;
        Set<RoleDTO> roles;
        if (user.getRoles() != null)
            roles = user.getRoles();
        else roles = new HashSet<>();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ;
        roles.add(roleService.getRole("ROLE_USER"));
        user.setRoles(roles);

        userRepository.save(UserMap.toEntity(user));
        return user;
    }

    public Set<RoleDTO> addRole(UserDTO userDTO, String roleName) {
        Set<RoleDTO> roleDTOS = userDTO.getRoles();
        if (roleService.getRole(roleName) == null) roleService.addRole(roleName);
        roleDTOS.add(roleService.getRole(roleName));
        userDTO.setRoles(roleDTOS);
        userRepository.save(UserMap.toEntity(userDTO));

        return roleDTOS;
    }

    public boolean isAdmin(UserDTO userDTO) {
        boolean admin = false;
        Set<RoleDTO> roles = userDTO.getRoles();
        for (RoleDTO roleDTO : roles)
            if (roleDTO.getRoleName().equals("ROLE_ADMIN")) admin = true;
        return admin;
    }


}
