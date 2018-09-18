package com.example.demo.repository;

import com.example.demo.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findRoleByRoleName(String name);
}
