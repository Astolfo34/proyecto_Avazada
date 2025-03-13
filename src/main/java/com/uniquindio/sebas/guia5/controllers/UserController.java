package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.UserRegistration;
import com.uniquindio.sebas.guia5.dtos.UserResponse;
import com.uniquindio.sebas.guia5.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServices userServices;

    @PostMapping
    public ResponseEntity<UserResponse>createUser(@RequestBody UserRegistration request){
        return ResponseEntity.ok(userServices.createUser(request));
    }

    @GetMapping
    public ResponseEntity<UserResponse>getUser(@PathVariable String id) {
        Optional<UserResponse> user = userServices.getUser(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
