package com.example.demo.domain.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDTO {

    private int userId;
    private String name;
    private String password;
    private String email;
    private List<RoleDTO> roles;
    private List<BasketDTO> baskets;
}
