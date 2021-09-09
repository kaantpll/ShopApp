package com.example.northwind.ShopApp.dto.request

import org.hibernate.annotations.NotFound
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateUserRequest(

    @field:NotBlank(message = "Email is not empty !!")
    val email : String,

    @field:Min(6)
    val password : String
)
