package com.example.onlineShop.repository;



import com.example.onlineShop.domain.entity.Basket;
import com.example.onlineShop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Integer> {

    public Basket findBasketByBasketId(Integer id);

    public Basket findBasketByUser(User user);
}
