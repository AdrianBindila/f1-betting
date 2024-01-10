package org.f1.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.dto.UserDTO;
import org.f1.model.User;
import org.f1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO u) {
        userService.createUser(modelMapper.map(u, User.class));
        return ResponseEntity.ok().build();
    }
}
