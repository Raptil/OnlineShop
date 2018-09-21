package com.example.demo.domain.dto;


import lombok.Data;

import java.util.List;
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
