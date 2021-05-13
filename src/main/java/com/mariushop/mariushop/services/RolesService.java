package com.mariushop.mariushop.services;

import com.mariushop.mariushop.entities.Roles;
import com.mariushop.mariushop.repositories.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class RolesService {

    private final RolesRepository rolesRepository;

    public Roles getRoleByName(String roleName) {
        return rolesRepository.findRolesByRoleName(roleName);
    }

    public Optional<Roles> findById(Integer id)
    {
        return rolesRepository.findById(id);
    }
}
