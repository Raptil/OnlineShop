package com.example.onlineShop.repository;


import com.example.onlineShop.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    public User findUserByEmail(String email);

    public User findUserByUserId(Integer id);

}
