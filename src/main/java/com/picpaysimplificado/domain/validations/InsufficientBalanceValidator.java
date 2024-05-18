package com.picpaysimplificado.domain.validations;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InsufficientBalanceValidator implements TransactionValidator{
    @Override
    public void validate(User user, BigDecimal amount) {
        if (user.getBalance().compareTo(amount) <  0) {
            throw new ValidationException("Insufficient balance to perform the transaction.");
        }
    }
}
