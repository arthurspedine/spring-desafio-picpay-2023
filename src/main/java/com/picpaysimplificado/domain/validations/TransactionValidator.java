package com.picpaysimplificado.domain.validations;

import com.picpaysimplificado.domain.user.User;

import java.math.BigDecimal;

public interface TransactionValidator {
    void validate(User user, BigDecimal amount);
}
