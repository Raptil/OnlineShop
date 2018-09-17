package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Table(name = "basket")
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;

    private int totalCost;

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(
           name = "product_to_basket",
           joinColumns = @JoinColumn(name="basket_id"),
           inverseJoinColumns = @JoinColumn(name = "product_id")
   )
    private List<Product> products;

   @ManyToOne
   @JoinColumn(name = "user_id")
    private User user;
}
