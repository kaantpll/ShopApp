package com.example.northwind.ShopApp.jwt

data class UsernameAndPasswordAuthenticationRequest(
    val username : String,
    val password : String
)