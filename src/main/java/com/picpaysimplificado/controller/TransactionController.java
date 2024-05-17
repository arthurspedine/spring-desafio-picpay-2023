package com.picpaysimplificado.controller;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.dto.TransactionDTO;
import com.picpaysimplificado.dto.TransactionDetailDTO;
import com.picpaysimplificado.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping
    public ResponseEntity<TransactionDetailDTO> createTransaction(@RequestBody TransactionDTO dto) throws Exception {
        Transaction transaction = service.createTransaction(dto);
        return new ResponseEntity<>(new TransactionDetailDTO(transaction), HttpStatus.CREATED);
    }
}
