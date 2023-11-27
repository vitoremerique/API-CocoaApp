package com.api.cocoa.controller;

import com.api.cocoa.record.LoginRequest;
import com.api.cocoa.repository.UserRepository;
import com.api.cocoa.service.impl.UserService;
import com.api.cocoa.user.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:8080") // Set the allowed origin(s) here

public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping
    @Operation(summary = "Retorna status para login")
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest loginRequest) {

        Usuario user = userService.findByName(loginRequest.name());


        if (user != null  && loginRequest.password().equals(user.getPassword())) {
            return ResponseEntity.ok(user);
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}