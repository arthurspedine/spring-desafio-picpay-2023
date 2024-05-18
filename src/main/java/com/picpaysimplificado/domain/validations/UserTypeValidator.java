package com.picpaysimplificado.domain.validations;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserTypeValidator implements TransactionValidator{
    @Override
    public void validate(User user, BigDecimal amount) {
        if (user.getUserType() == UserType.MERCHANT) {
            throw new ValidationException("User type MERCHANT is not authorized to carry out transactions!");
        }
    }
}
