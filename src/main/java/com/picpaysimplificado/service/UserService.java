package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dto.UserDTO;
import com.picpaysimplificado.infra.exception.ValidationException;
import com.picpaysimplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ValidationException("User not found!"));
    }

    public void saveUser(User user) {
        repository.save(user);
    }

    public User createUser(UserDTO dto) {
        User newUser = dto.getUser();
        saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
