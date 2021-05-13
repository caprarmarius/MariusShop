package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.UserDTO;
import com.mariushop.mariushop.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserMapper {

    private final RoleMapper roleMapper;
    private final CartMapper cartMapper;

    public UserDTO mapUserToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getUserId())
                .fullName(user.getFistName() + " " + user.getLastName())
                .password(user.getPassword())
                .username(user.getUsername())
                .emailAddress(user.getEmailAddress())
                .role(roleMapper.mapRoleToRoleDTO(user.getRole()))
                .cart(cartMapper.mapCartListToCartDTOList(user.getSelectedProducts()))
                .build();
    }
}
