package com.example.demo.repository;


import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Test
    public void saveUserWithRole(){
        User user=new User();
        user.setName("userName");
        user.setPassword("userPassword");
        user.setEmail("userEmail");
        List<Role> roles=new ArrayList<>();
        Role role =new Role("USER");
        roleRepository.save(role);
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
