package com.example.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@ToString
@Table(name = "role")
@Entity
public class Role {

    public Role(String roleName){
        this.roleName=roleName;
    }
    public Role(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;


    @Column(name = "role_name")
    private String roleName;

    //@ManyToMany(mappedBy = "role")
    //public List<User> users;



}
