package com.example.northwind.ShopApp.auth.registration

data class RegistrationRequest(
    val username : String,
    val email:String,
    val password : String,
)