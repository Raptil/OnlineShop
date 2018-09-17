package com.example.demo.repository;

import com.example.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Алексей on 17.09.2018.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findByRoleName(String name);
}
