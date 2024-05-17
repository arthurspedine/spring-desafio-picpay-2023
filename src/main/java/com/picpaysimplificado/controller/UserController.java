package com.picpaysimplificado.controller;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dto.UserDTO;
import com.picpaysimplificado.dto.UserDetailDTO;
import com.picpaysimplificado.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDetailDTO> createUser(@RequestBody UserDTO dto) {
        User newUser = userService.createUser(dto);
        return new ResponseEntity<>(new UserDetailDTO(newUser), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<UserDetailDTO>> getAllUsers() {
        List<User> users = this.userService.getAllUsers();
        List<UserDetailDTO> usersDTO = users.stream().map(UserDetailDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    }
}
