package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
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
    @Setter
    @Getter
    private String roleName;

    //@ManyToMany(mappedBy = "role")
    //public List<User> users;


    public int getRoleId() {
        return roleId;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
