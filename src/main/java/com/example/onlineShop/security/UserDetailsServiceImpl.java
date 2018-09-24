package com.example.onlineShop.security;

import com.example.onlineShop.domain.entity.User;
import com.example.onlineShop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user =userRepository.findUserByEmail(email);

        if(user==null) throw new UsernameNotFoundException(email);



        return user;
    }
}
