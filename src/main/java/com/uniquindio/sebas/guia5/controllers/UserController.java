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

    //CRUD
    //CREATE
    @PostMapping
    public ResponseEntity<UserResponse>createUser(@RequestBody UserRegistration request){
        return ResponseEntity.ok(userServices.createUser(request));
    }

    //Read
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
        Optional<UserResponse> user = userServices.getUser(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //Update
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRegistration request) {
        Optional<UserResponse> updatedUser = userServices.updateUser(id, request);
        return updatedUser.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        boolean deleted = userServices.deleteUser(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();  // 404 Not Found
        }
    }


}
