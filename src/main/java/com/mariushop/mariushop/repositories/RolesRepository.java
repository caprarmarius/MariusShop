package com.mariushop.mariushop.repositories;

import com.mariushop.mariushop.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolesRepository extends JpaRepository<Roles, Integer> {

   // Roles findRoleByRolename(String name);
    Roles findRolesByRoleName(String name);
}
