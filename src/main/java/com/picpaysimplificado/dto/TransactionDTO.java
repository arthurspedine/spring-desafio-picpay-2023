package com.picpaysimplificado.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;

public record TransactionDTO(
        BigDecimal value,
        @JsonAlias({"sender", "payer"})
        Long payerId,
        @JsonAlias({"receiver", "payee"})
        Long payeeId) {
}
