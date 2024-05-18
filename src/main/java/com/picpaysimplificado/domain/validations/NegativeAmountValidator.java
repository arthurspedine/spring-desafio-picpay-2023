package com.picpaysimplificado.domain.validations;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NegativeAmountValidator implements TransactionValidator{
    @Override
    public void validate(User user, BigDecimal amount) {
        if (amount.doubleValue() <= 0) {
            throw new ValidationException("Amount value is negative or 0!");
        }
    }
}
