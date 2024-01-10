package org.f1.controller;

import lombok.extern.slf4j.Slf4j;
import org.f1.dto.LoginDTO;
import org.f1.model.User;
import org.f1.service.AuthentificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthentificationController {
    private final AuthentificationService authService;

    public AuthentificationController(AuthentificationService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO) {
        User user = authService.login(loginDTO.getUsername());

        if (user == null || !user.getPassword().equals(loginDTO.getPassword())) {
            log.info("User " + loginDTO.getUsername() + " not found!");
            return ResponseEntity.notFound().build();
        }
        log.info("User " + loginDTO.getUsername() + " successfully logged in!");
        return ResponseEntity.ok(loginDTO);
    }

    @PostMapping("/reset-mail")
    public ResponseEntity<?> resetPasswordMail(@RequestBody String username) {
        //TODO: send an email to reset the user's password
        log.info("Successfully sent mail!");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetPassword() {
        //TODO:
        return ResponseEntity.ok().build();
    }
}
