package com.example.northwind.ShopApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ABC {

    @GetMapping
    private ResponseEntity<String> bas(){
        return ResponseEntity.ok(" Welcome Login Page ");
    }
}
