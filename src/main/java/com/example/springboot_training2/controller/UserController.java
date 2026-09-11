package com.example.springboot_training2.controller;

import com.example.springboot_training2.dto.UserRequestDTO;
import com.example.springboot_training2.dto.UserResponseDTO;
import com.example.springboot_training2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponseDTO> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto){
        UserResponseDTO response = userService.saveUser(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserRequestDTO dto, @PathVariable Long id) {
        UserResponseDTO response = userService.updateUserById(id, dto);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
         userService.deleteUserByIdS(id);
         return ResponseEntity.noContent().build();
    }
}
