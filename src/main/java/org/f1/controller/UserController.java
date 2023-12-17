package org.f1.controller;

import org.f1.dto.UserDTO;
import org.f1.model.User;
import org.f1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userService.getUser(username);
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO u) {
        userService.createUser(modelMapper.map(u, User.class));
    }
}
