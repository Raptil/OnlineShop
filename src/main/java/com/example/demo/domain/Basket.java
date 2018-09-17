package com.example.demo.domain;

import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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
           joinColumns = @JoinColumn(name="basket_id"),
           inverseJoinColumns = @JoinColumn(name = "product_id")
   )
    private List<Product> products;

   @ManyToOne
   @JoinColumn(name = "user_id")
    private User user;

    public int getBasketId() {
        return basketId;
    }


    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "basketId=" + basketId +
                ", totalCost=" + totalCost +
                ", products=" + products +
                ", user=" + user +
                '}';
    }
}
