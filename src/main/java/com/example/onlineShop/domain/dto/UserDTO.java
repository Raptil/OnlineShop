package com.example.onlineShop.domain.dto;


import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private int userId;
    private String name;
    private String password;
    private String email;
    private Set<RoleDTO> roles;
  //  private List<BasketDTO> baskets;


}
