package com.example.demo.repository;



import com.example.demo.domain.entity.Basket;
import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Integer> {

    public Basket findBasketByBasketId(Integer id);

    public Basket findBasketByUser(User user);
}
