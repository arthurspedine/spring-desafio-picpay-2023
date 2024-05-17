package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User payer, BigDecimal amount) throws Exception {
        if (payer.getUserType() == UserType.MERCHANT) {
            throw new Exception("User type MERCHANT is not authorized to carry out transactions!");
        }
        if (payer.getBalance().compareTo(amount) <  0) {
            throw new Exception("Insufficient balance to perform the transaction.");
        }
    }

    public User findUserById(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("User not found!"));
    }

    public void saveUser(User user) {
        repository.save(user);
    }
}
