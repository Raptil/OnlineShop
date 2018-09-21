package com.example.onlineShop.repository;

import com.example.onlineShop.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role,Integer> {

    public Role findRoleByRoleName(String name);

    public Role findRoleByRoleId(Integer id);
}
