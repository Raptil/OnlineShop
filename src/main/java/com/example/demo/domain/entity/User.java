package com.example.demo.domain.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Table(name = "user_account")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_account_to_role",
            joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns=@JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @OneToMany
    private List<Basket>baskets;


}
