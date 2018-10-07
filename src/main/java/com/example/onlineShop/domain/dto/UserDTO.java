package com.example.onlineShop.domain.dto;


import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class UserDTO {

    private int userId;
    @Size(min=3,max = 10,message = "count of characters from 3 to 10")
    private String name;
    @Size(min=3,max = 10,message = "count of characters from 3 to 10")
    private String password;
    @Size(min=3,max = 10,message = "count of characters from 3 to 10")
    private String email;
    private Set<RoleDTO> roles;



}
