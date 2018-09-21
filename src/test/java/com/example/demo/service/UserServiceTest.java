package com.example.demo.service;


import com.example.demo.domain.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    public void registryUserTest(){
        UserDTO user=new UserDTO();
        user.setEmail("EmailOfNewUser12");
        user.setPassword("His password");
        user.setName("NewName");
        userService.registryUser(user);

    }
}
