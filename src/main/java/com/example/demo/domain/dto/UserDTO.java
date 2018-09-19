package com.example.demo.domain.dto;


import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private int userId;
    private String name;
    private String password;
    private String email;
    private List<RoleDTO> roles;
    private List<BasketDTO> baskets;
}
