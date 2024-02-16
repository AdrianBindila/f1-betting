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
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOS = users.stream().map(user -> modelMapper.map(user,UserDTO.class)).toList();
        return ResponseEntity.ok(userDTOS);
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
