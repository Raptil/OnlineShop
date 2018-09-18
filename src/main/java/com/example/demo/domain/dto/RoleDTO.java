package com.example.demo.domain.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RoleDTO {

    private int roleId;
    private String roleName;
}
