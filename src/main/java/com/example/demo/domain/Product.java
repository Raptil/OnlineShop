package com.example.demo.domain;

import javax.persistence.*;

@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String name;

    private int cost;

    private String category;

    //@ManyToMany(mappedBy = "product")
    //private Basket basket;

}
