package com.example.onlineShop.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Table(name = "basket")
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private int basketId;

    @Column(name = "total_cost")
    private int totalCost;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_to_basket",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")

    private User user;


}
