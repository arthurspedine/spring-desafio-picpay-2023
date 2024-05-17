package com.picpaysimplificado.dto;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;

import java.math.BigDecimal;

public record UserDetailDTO(
        Long id,
        String firstName,
        String lastName,
        String document,
        String email,
        BigDecimal balance,
        UserType userType

) {
    public UserDetailDTO(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getDocument(), user.getEmail(), user.getBalance(), user.getUserType());
    }
}
