package com.mariushop.mariushop.mappers;

import com.mariushop.mariushop.dtos.LogInDTO;
import com.mariushop.mariushop.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class LogInMapper {
    public LogInDTO mapUserToLogInDTO(User user) {
        return LogInDTO.builder()
                .username(user.getUsername())
                .fullName(user.getFistName() + " " + user.getLastName())
                .password(user.getPassword())
                .roles(user.getRole().getRoleName())
                .build();
    }
}
