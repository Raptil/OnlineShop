package com.example.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name")
    private String name;

    @Column(name="cost")
    private int cost;

    @Column(name = "category")
    private String category;

    //@ManyToMany(mappedBy = "product")
    //private Basket basket;



}
