package org.f1.service;

import org.f1.model.User;
import org.f1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService {
    private final UserRepository userRepository;

    public AuthentificationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username) {
        return userRepository.findByUsername(username);
    }
}
