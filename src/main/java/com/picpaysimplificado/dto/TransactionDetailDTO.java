package com.picpaysimplificado.dto;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.domain.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDetailDTO(
        Long id,
        BigDecimal value,
        LocalDateTime log,
        UserDetailDTO payer,
        UserDetailDTO payee
) {
    public TransactionDetailDTO(Transaction transaction) {
        this(transaction.getId(), transaction.getAmount(), transaction.getLogDateTime(), new UserDetailDTO(transaction.getPayer()), new UserDetailDTO(transaction.getPayee()));
    }
}
