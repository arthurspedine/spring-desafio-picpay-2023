package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dto.TransactionDTO;
import com.picpaysimplificado.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private UserService service;

    @Autowired
    private TransactionRepository repository;
    @Autowired
    private UserService userService;

    public void createTransaction(TransactionDTO dto) throws Exception {
        User payer = service.findUserById(dto.payerId());
        User payee = service.findUserById(dto.payeeId());

//        validate if payer has enough balance and if is not MERCHANT
        service.validateTransaction(payer, dto.value());

        Transaction transaction = new Transaction();
        transaction.setAmount(dto.value());
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        transaction.setLogDateTime(LocalDateTime.now());

        payer.setBalance(payer.getBalance().subtract(transaction.getAmount()));
        payee.setBalance(payee.getBalance().add(transaction.getAmount()));

        repository.save(transaction);
        userService.saveUser(payer);
        userService.saveUser(payee);
    }
}
