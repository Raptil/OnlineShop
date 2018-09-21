package com.example.demo.repository;


import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User,Integer> {

    public User findUserByEmail(String email);

    public User findUserByUserId(Integer id);

}
