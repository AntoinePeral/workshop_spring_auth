package org.wcs.invoice_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wcs.invoice_api.dto.UserRegistrationDTO;
import org.wcs.invoice_api.entity.User;
import org.wcs.invoice_api.service.UserService;

import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        User registeredUser = userService.registerUser(
                userRegistrationDTO.getEmail(),
                userRegistrationDTO.getPassword(),
                Set.of("ROLE_USER") // Par défaut, chaque utilisateur aura le rôle "USER"
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
}
