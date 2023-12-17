package org.f1.service;

import org.f1.model.User;
import org.f1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User u) {
        userRepository.save(u);
    }

    public void removeUser(User u) {
        userRepository.delete(u);
    }

    public void updateUser(User u) {
        userRepository.save(u);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
