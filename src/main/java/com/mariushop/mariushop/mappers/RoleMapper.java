package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.RoleDTO;
import com.mariushop.mariushop.entities.Roles;
import org.springframework.stereotype.Component;


@Component
public class RoleMapper {

    public RoleDTO mapRoleToRoleDTO(Roles role) {
        return RoleDTO.builder()
                .id(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
    }
}
