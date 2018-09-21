package com.example.onlineShop.repository;


import com.example.onlineShop.domain.entity.Role;
import com.example.onlineShop.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

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
        Integer numb=(int)(10+Math.random()*10);
        user.setName("userName"+numb);
        user.setPassword("userPassword"+numb);
        user.setEmail("userEmail"+numb);
        Set<Role> roles=new HashSet<>();
        roles.add(roleRepository.findRoleByRoleName("USER"));
        user.setRoles(roles);
        userRepository.save(user);
    }
}
