package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

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
