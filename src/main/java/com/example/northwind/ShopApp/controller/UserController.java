package com.example.northwind.ShopApp.controller;

import com.example.northwind.ShopApp.dto.UserDto;
import com.example.northwind.ShopApp.dto.request.CreateUserRequest;
import com.example.northwind.ShopApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping
    private ResponseEntity<UserDto> addNewUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.ok(userService.addNewUser(createUserRequest));
    }
}
